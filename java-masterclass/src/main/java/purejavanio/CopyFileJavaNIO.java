package purejavanio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;

public class CopyFileJavaNIO {

    public static void main(String[] args) {
        copyFileJavaNIO("copy.dat", "bindata.bin");
        copyUsingTransferTOJavaNIO("copy2.dat", "bindata.bin");

        writeAndReadFromPipeUsingThreads();
    }

    private static void writeAndReadFromPipeUsingThreads() {
        // Pipes are used to transfer data between threads in a one-way direction
        // Pipes have a sync and a source channel, one thread writes to the sync, and the rest reads from the source
        try {
            Pipe pipe = Pipe.open();

            // Writer thread
            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink(); // gets sink channel
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            String currentTime = "The time is " + System.currentTimeMillis();
                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while(buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            // Reader thread
            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            // Start threads
            new Thread(writer).start();
            new Thread(reader).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyUsingTransferTOJavaNIO(String newFile, String fileToCopyFrom) {
        try(RandomAccessFile copyFile = new RandomAccessFile(newFile, "rwd");
            FileChannel copyChannel = copyFile.getChannel();
            RandomAccessFile readFile = new RandomAccessFile(fileToCopyFrom, "rwd");
            FileChannel readChannel = readFile.getChannel();
        ) {
            // Set readChannel (file we copy from) position to 0, in order to start from the beginning
            readChannel.position(0);
            // Alternative way to copy
            long numTransferred = readChannel.transferTo(0, readChannel.size(), copyChannel);
            System.out.println("Num transferred: " + numTransferred);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyFileJavaNIO(String newFile, String fileToCopyFrom) {
        try(RandomAccessFile copyFile = new RandomAccessFile(newFile, "rwd");
            FileChannel copyChannel = copyFile.getChannel();
            RandomAccessFile readFile = new RandomAccessFile(fileToCopyFrom, "rwd");
            FileChannel readChannel = readFile.getChannel();
        ) {
            // Set readChannel (file we copy from) position to 0, in order to start from the beginning
            readChannel.position(0);
            // last two args specifies how many bytes to copy: 0 - n
            // TransferFrom uses a relative value of buffer position
            long numTransferred = copyChannel.transferFrom(readChannel, 0, readChannel.size());
            System.out.println("Num transferred: " + numTransferred);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
