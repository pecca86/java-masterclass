package regex;

public class RegexDemo {
    public static void main(String[] args) {
        // EXAMPLE 1
        String myString = "Tim's mom lives on my cock, does that mean she is one?";
        String replace = myString.replaceAll("cock", "fallos");
        System.out.println(replace);

        // EXAMPLE 2
        String replaceMePlz = "adawkodka2323akdYY2YYoskd";
        System.out.println(replaceMePlz.replaceAll(".", "T")); // Replaces all chars with T

        // EXAMPLE 3
        System.out.println(replaceMePlz.replaceAll("^adaw", "KAKKA")); // ^ = the beginning of the string

        // EXAMPLE 4
        System.out.println(replaceMePlz.matches("^helooo")); // false, whole string needs to match

        // EXAMPLE 5
        System.out.println(replaceMePlz.replaceAll("kd$", "FITTA"));

        // EXAMPLE 6
        System.out.println(replaceMePlz.replaceAll("[23]", "TVÅTRE"));

        // EXAMPLE 7
        // replace 2 / 3 ONLY if has a letter coming after them
        System.out.println(replaceMePlz.replaceAll("[23][a-zA-Z]", "REPLACED"));
    }
}
