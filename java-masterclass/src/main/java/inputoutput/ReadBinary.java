package inputoutput;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadBinary {

    // using big_old_cock.txt
    public static void main(String[] args) {
        // Java will throw a EOFException / IOException when EOF
        try(DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("big_old_cock.txt")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    int txt = in.readByte();
                    String s = Character.toString(txt);
                    System.out.println("Read text: " + s);
                } catch (EOFException e) {
                    System.out.println("Reached EOF");
                    eof = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }
}
