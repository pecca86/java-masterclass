package lambdas_functions.functions;

import java.util.function.IntUnaryOperator;

public class UnaryFunctionDemo {

    public static void main(String[] args) {
        // Takes int an Integer and returns an Integer
        IntUnaryOperator incByFive = i -> i + 5;
        System.out.println(incByFive.applyAsInt(10));
    }
}
