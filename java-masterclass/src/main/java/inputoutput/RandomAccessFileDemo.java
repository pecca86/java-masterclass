package inputoutput;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Read a file from a given offset
 */
public class RandomAccessFileDemo {

    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    //private static RandomAccessFile raf;

    public static void main(String[] args) {
        createRandomAccessFile();

        readFromRandomAccessFile();
    }

    private static void readFromRandomAccessFile() {
        try(RandomAccessFile raf = new RandomAccessFile("data.dat", "rwd")) {
            int numData = raf.readInt();
            long dataStartPoint = raf.readInt(); // Get offset

            // While pointer is less than offset where data begins
            while (raf.getFilePointer() < dataStartPoint) {
                int dataId = raf.readInt();
                int dataStart = raf.readInt();
                int dataLength = raf.readInt();

                IndexRecord record = new IndexRecord(dataStart, dataLength);
                index.put(dataId, record);
            }

            System.out.println(index);

            for (Integer id : index.keySet()) {
                raf.seek(index.get(id).getStartByte());
                int rId = raf.readInt();
                String data = raf.readUTF(); // readUTF knows how many bytes to read, bc writeUTF sets a pointer
                String appended = raf.readUTF();
                String[] appendedArray = new String(appended).split(",");

                System.out.println("ID: " + rId + ", data: " + data);
                Arrays.stream(appendedArray)
                        .forEach(System.out::println);
                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createRandomAccessFile() {
        // rwd = read, write, asynchronously
        try(RandomAccessFile rao = new RandomAccessFile("data.dat", "rwd")) {
            rao.writeInt(10); // How many bytes to reserve
            int indexSize = 10 * 3 * Integer.BYTES;
            // Calculates offset to where the data section begins, this also takes into account
            // the amount of data already written to the file
            int dataStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
            rao.writeInt(dataStart);

            // Build index in memory, to save us from having to do a lot of disk access, we save the place of the pointer
            long indexStart = rao.getFilePointer();

            int startPointer = dataStart;
            rao.seek(startPointer); // Sets the pointer

            for (int i = 0; i < 10; i++) {
                rao.writeInt(i);
                rao.writeUTF("datapoint: " + i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 2; j++) {
                    sb.append("Appender " + j + ",");
                    if (i == 5) {
                        sb.append("Appender: SUCK A COCK!,");
                    }
                }
                rao.writeUTF(sb.toString());

                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
                index.put(i, record);

                // Update pointer
                startPointer = (int) rao.getFilePointer();
            }

            rao.seek(indexStart); // Get pointer to correct offset and write to file
            for (Integer id : index.keySet()) {
                rao.writeInt(id);
                rao.writeInt(index.get(id).getStartByte());
                rao.writeInt(index.get(id).getLength());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
