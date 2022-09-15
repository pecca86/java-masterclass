package flow;

public class Summer {
    public static void main(String[] args) {
        System.out.println(sumDigits(125));
        printFactors(10);
    }

    public static int sumDigits(int digit) {
        if (digit < 10) {
            return -1;
        }

        int result = 0;

        while (digit > 0) {
            result += digit % 10;
            digit = digit / 10;
        }

        return result;
    }

    public static void printFactors(int num) {
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.println(i);
            }
        }
    }
}
