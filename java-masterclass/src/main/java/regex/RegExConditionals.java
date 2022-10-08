package regex;

public class RegExConditionals {
    public static void main(String[] args) {
        // EXAMPLE 1, OR-Operator
        System.out.println("harry".replaceAll("[H|h]arry", "Dick"));

        // EXAMPLE 2, not operator - find all i's not followed by m | M
        System.out.println("DickIniMouth".replaceAll("i[^m|M]", "X"));
        System.out.println("DickIniMouth".replaceAll("i(?!m|M)", "X"));
        System.out.println("DickIniMouth".replaceAll("i(?=m|M)", "X"));


    }
}
