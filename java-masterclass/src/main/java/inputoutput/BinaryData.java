package inputoutput;

public class BinaryData {

    public static void main(String[] args) {
        shiftInt(922342959);
    }

    private static void shiftInt(int v) {
        int x;
        display(v >>> 24);
        display(v >>> 16);
        display(v >>> 8);
        display(v >>> 0);

    }

    private static void display(int x) {
        String all = String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0");
        int y = x & 0xFF;
        String output = String.format("%10d and 0xFF is %8s \t %10d is ", y, Integer.toBinaryString(y), x) + all;
        System.out.println(output);
    }
}
