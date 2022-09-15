package purejavanio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BinaryJavaNIO {

    public static void main(String[] args) {

        System.out.println("\n=== WRITE 1 ===\n");
        writeNIOBinFile();

        System.out.println("\n=== WRITE 2 ===\n");
        writeAllDataAtOnceJavaNIO();

        System.out.println("\n=== READ 1 ===\n");
        readAllDataAtOnceJavaNIO();

        System.out.println("\n=== READ 2 ===\n");
        readDataNIOMethod1();

        System.out.println("\n=== READ 3 ===\n");
        readDataNIOMethod2();

        System.out.println("\n=== WRITE / READ ===\n");
        writeBackwardsUsingJavaNIO();
    }

    private static void writeBackwardsUsingJavaNIO() {
        try(RandomAccessFile in = new RandomAccessFile("allatonceback.dat", "rwd");
            FileChannel channel = in.getChannel();
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputBytes = "Hello World".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(100);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-232);
            byte[] outputBytes2 = "Nice guy, big cock".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);
            // Buffer position back to 0
            buffer.flip();
            channel.write(buffer);

            // Read the just written file
            RandomAccessFile inFile = new RandomAccessFile("allatonceback.dat", "rwd");
            FileChannel inChannel = inFile.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            inChannel.read(byteBuffer);
            System.out.println(byteBuffer.getInt((int) int3Pos));
            System.out.println(byteBuffer.getInt((int) int2Pos));
            System.out.println(byteBuffer.getInt((int) int1Pos));



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readAllDataAtOnceJavaNIO() {
        try(RandomAccessFile in = new RandomAccessFile("allatonce.dat", "rwd");
            FileChannel channel = in.getChannel();
        ) {
            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();

            byte[] inputString = new byte["Hello World".getBytes().length];
            readBuffer.get(inputString);
            System.out.println("Input: " + new String(inputString));
            System.out.println("Int 1: " + readBuffer.getInt());
            System.out.println("Int 2: " + readBuffer.getInt());
            byte[] inputString2 = new byte["Nibe guy, big cock".getBytes().length];
            readBuffer.get(inputString2);
            System.out.println("Input 2: " + new String(inputString2));
            System.out.println("Int 3: " + readBuffer.getInt());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeAllDataAtOnceJavaNIO() {

        try(FileOutputStream out = new FileOutputStream("allatonce.dat");
            FileChannel channel = out.getChannel();
        )  {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputBytes = "Hello World".getBytes();
            buffer.put(outputBytes);
            buffer.putInt(100);
            buffer.putInt(-232);
            byte[] outputBytes2 = "Nice guy, big cock".getBytes();
            buffer.put(outputBytes2);
            buffer.putInt(1000);
            // Buffer position back to 0
            buffer.flip();
            channel.write(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readDataNIOMethod2() {
        try(RandomAccessFile file = new RandomAccessFile("bindata.dat", "rwd");
        ) {
            FileChannel channel = file.getChannel();
            byte[] outputBytes = "Hello, World!".getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            // Change chars at given buffer offset, in memory
            outputBytes[0] = 'S';
            buffer.flip();

            long numBytesRead = channel.read(buffer);

            if(buffer.hasArray()) {
                System.out.println("Output bytes = " + new String(outputBytes));
                System.out.println("Output bytes = " + new String(buffer.array()));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readDataNIOMethod1() {
        // Read file using Java NIO
        try(RandomAccessFile file = new RandomAccessFile("bindata.bin", "rwd")) {
            byte[] b = new byte["Hello, World!".getBytes().length];
            file.read(b);
            System.out.println(new String(b));

            long int1 = file.readInt();
            long int2 = file.readInt();
            System.out.println(int1 + " " + int2);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeNIOBinFile() {
        // Writing to a binary file
        try(FileOutputStream binFile = new FileOutputStream("bindata.bin");
            FileChannel binChannel = binFile.getChannel()
        ) {
            // Writes as utf-8
            byte[] outputBytes = "Hello, World!".getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes); // creates the buffer
            int numBytes = binChannel.write(buffer); // Return how many bytes were written
            System.out.println("Bytes written: " + numBytes);

            // Write as binary
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES); // Pass bytes we want to write (4b = int)
            intBuffer.putInt(240);
            // Resets buffer to offset 0
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("Number of intBytes written: " + numBytes);

            // Write a negative integer
            // Resets buffer to offset 0
            intBuffer.flip();
            intBuffer.putInt(-1240);
            // Resets buffer to offset 0
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("Number of intBytes written: " + numBytes);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
