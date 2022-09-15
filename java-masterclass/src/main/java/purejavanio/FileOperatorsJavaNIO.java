package purejavanio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class FileOperatorsJavaNIO {
    public static void main(String[] args) {
//        copyFileJavaNIO();

//        copyAndOverwriteIfExists();

//        copyDir();

//        fileMv();

//        renameFile();

//        deleteFile();

//        createAFile();

//        createDir();

//        createMultipleDirs(new String[]{"p1", "p2", "p3"});
//        createMultipleDirs2("k1", "k2", "k3");
        
//        fileAttributes();

        getAllFileAttributes();
    }

    private static void getAllFileAttributes() {
        try {
            Path filePath = FileSystems.getDefault().getPath("testfiles/k1/k2/","amihere.txt");

            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size: " + attrs.size());
            System.out.println("Last modified: " + attrs.lastModifiedTime());
            System.out.println("Created: " + attrs.creationTime());
            System.out.println("Is regular file: " + attrs.isRegularFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createMultipleDirs2(String ...dirs) {
        try {
            StringBuilder sb = new StringBuilder();
            for (String s : dirs) {
                sb.append(s+"/");
            }
            String parsedDirs = sb.toString();
            Path rootDir = FileSystems.getDefault().getPath("testfiles", parsedDirs);
            Files.createDirectories(rootDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createMultipleDirs(String[] dirs) {
        try {
            StringBuilder sb = new StringBuilder();
            for (String s : dirs) {
                sb.append(s+"/");
            }
            String parsedDirs = sb.toString();
            Path rootDir = FileSystems.getDefault().getPath("testfiles", parsedDirs);
            Files.createDirectories(rootDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createDir() {
        try {
            Path dirToCreate = FileSystems.getDefault().getPath("testfiles", "newDir");
            if (!Files.exists(dirToCreate)) {
                Files.createDirectory(dirToCreate);
            } else {
                System.out.println("Dir already exists!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This does not write to the file, only creates it.
     * To write to the file, you still need to open a write buffer.
     */
    private static void createAFile() {
        try {
            Path fileToCreate = FileSystems.getDefault().getPath("testfiles", "created2022.txt");
            if (!Files.exists(fileToCreate)) {
                Files.createFile(fileToCreate);
            } else {
                System.out.println("File already found!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fileAttributes() {
        try {
            Path filePath = FileSystems.getDefault().getPath("testfiles/k1/k2/","amihere.txt");
            long fileSize = Files.size(filePath);
            FileTime lastModified = Files.getLastModifiedTime(filePath);
            UserPrincipal owner = Files.getOwner(filePath);
            System.out.println("File size: " + fileSize);
            System.out.println("File lastmodified: " + lastModified);
            System.out.println("File owner: " + owner);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void deleteFile() {
        try {
            Path fileToDelete = FileSystems.getDefault().getPath("testfiles", "dir1", "copyOfSubdir.txt");
            // Files.deleteIfExists(fileToDelete);
            if (Files.exists(fileToDelete)) {
                Files.delete(fileToDelete);
                System.out.println("Deleted: " + fileToDelete.getFileName());
            } else {
                System.out.println("File does not exist!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void renameFile() {
        try {
            Path fileToRename = FileSystems.getDefault().getPath("testfiles", "subdir.txt");
            Path renamed = FileSystems.getDefault().getPath("testfiles", "subdirNew.txt");
            Files.move(fileToRename, renamed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileMv() {
        try {
            Path fileToMove = FileSystems.getDefault().getPath("testfiles", "copyOfSubdir.txt");
            Path destination = FileSystems.getDefault().getPath("testfiles", "dir1", "copyOfSubdir.txt");
            Files.move(fileToMove, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyDir() {
        try {
            Path sourceFile = FileSystems.getDefault().getPath("testfiles", "dir1");
            // Copies dir1 to new dir => dir4, will not copy any files existing inside dir1
            Path copyFile = FileSystems.getDefault().getPath("testfiles", "dir4");
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING); // third param added
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyAndOverwriteIfExists() {
        try {
            Path sourceFile = FileSystems.getDefault().getPath("testfiles", "subdir.txt");
            Path copyFile = FileSystems.getDefault().getPath("testfiles", "copyOfSubdir.txt");
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING); // third param added
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileJavaNIO() {
        try {
            Path sourceFile = FileSystems.getDefault().getPath("testfiles", "subdir.txt");
            Path copyFile = FileSystems.getDefault().getPath("testfiles", "copyOfSubdir.txt");
            Files.copy(sourceFile, copyFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
