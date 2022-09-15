package inputoutput;

import java.io.*;

/**
 * Serialization, serializes an object that we wish to save to a file.
 * This allows us to later retrieve and recreate that object from the data saved in the file.
 * It is always best practice to give the object your own ID for serialization. Otherwise different
 * compilers might deserialize the object wrongly.
 *
 * If the serializable class has fields containing other classes, those too need to be serializable!
 * (Unless they are primitives)
 *
 * Once the object has been serialized with an UID, it can only be deserialized with the same one
 * this will throw a InvalidClassException.
 *
 * Object instances will be unique to a file, but not across files (Two exact copies of String can't exist in same file
 * but can exist in two different ones).
 *
 */
public class ObjectSerialization implements Serializable {

    // Our object's Serializable number
    private final long serialVersionUID = 1L;

    public static void main(String[] args) {

        // Serialize the object
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("kisi.txt")))) {
            for (int i = 0; i < 5; i++) {
                out.writeObject(new String("Kukbyxa!")); // This could be any object implementing Serializable
            }
        } catch (IOException e) {
            System.out.println("No kukbyxa no!");
        }

        // Deserialize the object
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("kisi.txt")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    String s = (String) in.readObject();
                    System.out.println(s);

                } catch (EOFException | ClassNotFoundException e) {
                    System.out.println("E O F - M F !");
                    eof = true;
                }
            }
        } catch (IOException e) {
            System.out.println("IO EE, IO EE, I don't have no time for no monkey business!");
        }
    }

}
