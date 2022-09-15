package purejavanio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class PureJavaNIO {

    public static void main(String[] args) {

        writePureNIO();
        // best way is to eg. create the text you want to write to the file using
        // StringBuilder, and then write at one time everything (file is opened and written to only once)
        Path outPath = FileSystems.getDefault().getPath("write_w_nio.txt");
        try {
            Files.write(outPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.CREATE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writePureNIO() {
        // File channel
        try {
            // File channel only open for reading
//            FileInputStream file = new FileInputStream("data.dat");
//            FileChannel channel = file.getChannel();
            Path dataPath = FileSystems.getDefault().getPath("nio_file.txt");
            List<String> lines = Files.readAllLines(dataPath);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
