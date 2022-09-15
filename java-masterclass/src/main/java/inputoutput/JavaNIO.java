package inputoutput;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class JavaNIO {

    public static void main(String[] args) {
        writeWithNIO();
        readWithNIO();
    }

    private static void readWithNIO() {
        Path filePath = FileSystems.getDefault().getPath("nio_file.txt");

        try(Scanner in = new Scanner(Files.newBufferedReader(filePath))){
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeWithNIO() {
        Path filePath = FileSystems.getDefault().getPath("yo_moma.txt");
        Path cockPath = FileSystems.getDefault().getPath("nio_file.txt");

        try(BufferedWriter localFile = Files.newBufferedWriter(filePath);
            BufferedWriter cockFile = Files.newBufferedWriter(cockPath)
        ) {
            for (int i = 0; i < 10; i++) {
                localFile.write("Penis " + i);
                cockFile.write("Senap: " + i*2 + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
