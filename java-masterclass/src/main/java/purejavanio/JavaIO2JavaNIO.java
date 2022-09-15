package purejavanio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaIO2JavaNIO {

    public static void main(String[] args) {
        mapIOFileToNIOFile();
        findRelativePathIOvsNIO();
        workingDirUsingJavaIO();
        printFilesInFolderJavaIO();
        printFilesInFolderJavaIOUsingListFiles();
    }

    private static void printFilesInFolderJavaIOUsingListFiles() {
        System.out.println("== JAVA IO listFiles() ==");
        File dir1File = new File(new File("").getAbsoluteFile(), "testfiles/dir1");
        File[] dir1Files = dir1File.listFiles();
        for (int i = 0; i < dir1Files.length; i++) {
            System.out.println(dir1Files[i].getName());
        }
    }

    private static void printFilesInFolderJavaIO() {
        System.out.println("== JAVA IO list() ==");
        File workingDir = new File("").getAbsoluteFile();
        File dir1 = new File(workingDir, "/testfiles/dir1");
        String[] dir1Contents = dir1.list();
        for (int i = 0; i < dir1Contents.length; i++) {
            System.out.println(dir1Contents[i]);
        }
    }

    private static void workingDirUsingJavaIO() {
        File workingDir = new File("").getAbsoluteFile();
        System.out.println("Working Directory using Java IO: " + workingDir.getAbsolutePath());
    }

    private static void mapIOFileToNIOFile() {
        // JavaIO
        File file = new File("testfiles/testfile.txt");
        // JavaNIO
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);
    }

    private static void findRelativePathIOvsNIO() {
        // JavaIO
        File parent = new File("testfiles");
        File resolvedFile = new File(parent, "dir/file.txt");
        System.out.println(resolvedFile.toPath());
        resolvedFile = new File("testfiles", "dir/file.txt");
        System.out.println(resolvedFile.toPath());
        // JavaNIO
        Path parentPath = Paths.get("testfiles");
        Path childRelativePath = Paths.get("dir/file.txt");
        System.out.println(parentPath.resolve(childRelativePath));
    }
}
