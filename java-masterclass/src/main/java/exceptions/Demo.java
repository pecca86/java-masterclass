package exceptions;

public class Demo {

    public static void main(String[] args) throws Exception {
        divider(4, 1);
        divider(4, null);
    }

    public static double divider(Integer a, Integer b) {
        try {
            return a / b;
        } catch (ArithmeticException | NullPointerException e) {
            throw new RuntimeException("Invalid integers entered!");
        }
    }
}


