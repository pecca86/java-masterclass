package purejavanio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesystemJavaNIO {

    public static void main(String[] args) {

        // Relative path starting from Working Dir
        readFileUsingBufferedReader(FileSystems.getDefault().getPath("workingdir.txt"));
        readFileUsingBufferedReader(FileSystems.getDefault().getPath("./testfiles/subdir.txt"));
        readFileUsingBufferedReader(FileSystems.getDefault().getPath("testfiles", "subdir.txt"));
        readFileUsingBufferedReader(Paths.get(".", "testfiles", "subdir.txt"));


        // Absolute path
        Path path = Paths.get("/Users/pekkaranta-aho/Coding/Java/Udemy/javamaster/kikkeli.txt");
        readFileUsingBufferedReader(path);


        // Get absolute path without typing the whole path
        System.out.println(Paths.get(".").toAbsolutePath());
        System.out.println(Paths.get(".").toAbsolutePath().normalize()); // normalize removes the dot at the end


        // Check if file or dir exists
        Path nonExistingPath = FileSystems.getDefault().getPath("kukar.dat");
        System.out.println("Non-existing: " + nonExistingPath.toAbsolutePath());

        Path doesNotExist = Paths.get("/Pippeli", "kikkeli", "imnothere.txt");
        System.out.println("Not actually a dir: " + doesNotExist.toAbsolutePath());
        // Check if given path exists in FS
        System.out.println(doesNotExist.toAbsolutePath().normalize() + ", exists?: " + Files.exists(doesNotExist));

        // Check if user have permissions to read the file
        System.out.println("User has R: " + Files.isReadable(path));
    }

    private static void readFileUsingBufferedReader(Path path) {
        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
