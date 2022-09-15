package streams;


import java.util.Arrays;

public class StreamDemo {

    public static void main(String[] args) {

        int[] a = {1,1,1,1,1};
        int[] b = {9,9,9,9,9};

        int result = add(a, b);
        System.out.println(result);

    }

    /**
     *
     * @param a Array of integers
     * @param b Array of integers
     * @return result of sum of all elements from array a + b
     */
    public static int add(int[] a, int[] b) {
        return Arrays.stream(a).sum() + Arrays.stream(b).sum();
    }
}

