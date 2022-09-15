package inputoutput;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class JavaNIOObject implements Serializable {

    // Our object's Serializable number
    private final long serialVersionUID = 11L;

    public static void main(String[] args) {
        writeObjectToFile();
        readObjectFromFile();
    }

    private static void readObjectFromFile() {
        Path filePath = FileSystems.getDefault().getPath("kakka.dat");
        try(ObjectInputStream file = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(filePath)))) {
            boolean eof = false;
            while (!eof) {
                try {
                    System.out.println((String) file.readObject());
                } catch (EOFException | ClassNotFoundException e) {
                    eof = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeObjectToFile() {
        Path filePath = FileSystems.getDefault().getPath("kakka.dat");
        try(ObjectOutputStream file = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(filePath)))) {
            for (int i = 0; i < 10; i++) {
                file.writeObject(new String("Neehkheri " + 1+i + "\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
