package inputoutput;

import javax.imageio.IIOException;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreams {

    public static void main(String[] args) {
        try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("big_old_cock.txt")))) {
            out.writeInt('a');
            out.write("\n".getBytes());
            out.writeInt(1);
            out.writeUTF("Kakka");
        } catch (IOException e) {
            System.out.println("Something went wrong...");
        }
    }
}
