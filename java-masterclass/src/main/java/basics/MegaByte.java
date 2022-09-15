package basics;

public class MegaByte {
    private static final int KILOBYTE = 1024;

    public static void main(String[] args) {
        printKbToMb(3000);
    }

    public static void printKbToMb(int kb) {
        if (kb < 0) {
            System.out.println("Invalid value");
            return;
        }

        int mb = kb / KILOBYTE;
        int remainder = mb * KILOBYTE;
        int kbResult = kb - remainder;

        System.out.println(kb + " KB = " + mb + " MB and " + kbResult + " KB");
    }
}
