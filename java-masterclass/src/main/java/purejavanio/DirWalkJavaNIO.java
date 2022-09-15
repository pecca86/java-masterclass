package purejavanio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class DirWalkJavaNIO {
    public static void main(String[] args) {
//        iterateDirectoryAndSubdirectories();
//        iterateDirsAndFindOnlyDatFiles();
//        dirWalkWithFilter();
//        dirWalkWithFilterUsingLambda();
//        dirWalkWithOSSpecificSeparator();
//        createTempFile();
//        getFileStores();
//        walkFileTree();
        copyEntireTree();
    }

    /**
     * Copies the entire tree, starting from the root folder, to a new similar folder structure.
     * NB! Should add logic to handle recursive infinite creation of new folders, if copying new folders
     * into a folder that is also as a goal for the copy.
     */
    private static void copyEntireTree() {
        System.out.println("=== Copying file tree ===");
        Path rootDir = FileSystems.getDefault().getPath("testfiles" + File.separator + "dir2");

        // Path to copy to
        Path copyPath = FileSystems.getDefault().getPath("testfiles" + File.separator + "dir1" + File.separator + "dirCopy");

        try {
            Files.walkFileTree(rootDir, new CopyFiles(rootDir, copyPath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Walking every dir + files in dir, starting from root directory.
     */
    private static void walkFileTree() {
        System.out.println("=== Walking file tree ===");
        Path rootDir = FileSystems.getDefault().getPath("testfiles");
        try {
            Files.walkFileTree(rootDir, new PrintFileNames());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getFileStores() {
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores) {
            System.out.println("== " + store + " ==");
            System.out.println(store.name());
        }
    }

    private static void createTempFile() {
        try {
            Path tempFile = Files.createTempFile("tempApp", ".tmp");
            System.out.println("Location of temp file: " + tempFile.toAbsolutePath());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void dirWalkWithOSSpecificSeparator() {
        // Two ways of retrieving the OS specific separator
        String separator = File.separator;
        separator = FileSystems.getDefault().getSeparator();

        DirectoryStream.Filter<Path> filter = path -> Files.isRegularFile(path);

        Path dir = FileSystems.getDefault().getPath("testfiles" + File.separator + "dir2");
        // Here we use our filter as second param
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(dir, filter)) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void dirWalkWithFilterUsingLambda() {
        DirectoryStream.Filter<Path> filter = path -> Files.isRegularFile(path);

        Path dir = FileSystems.getDefault().getPath("testfiles");
        // Here we use our filter as second param
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(dir, filter)) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Here we filter out all directories and print only files
     */
    private static void dirWalkWithFilter() {
        // Define filter
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            public boolean accept(Path path) throws IOException {
                return Files.isRegularFile(path);
            }
        };

        Path dir = FileSystems.getDefault().getPath("testfiles");
        // Here we use our filter as second param
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(dir, filter)) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void iterateDirsAndFindOnlyDatFiles() {
        Path dir = FileSystems.getDefault().getPath(".");
        // Search using glob pattern matching, REGEX also available
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(dir, "*.dat")) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * NB! Does only show the contents of the first directory!
     */
    private static void iterateDirectoryAndSubdirectories() {
        Path dir = FileSystems.getDefault().getPath("testfiles");
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(dir)) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }
    }
}
