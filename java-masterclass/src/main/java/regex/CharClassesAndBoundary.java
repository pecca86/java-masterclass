package regex;

public class CharClassesAndBoundary {
    public static void main(String[] args) {
        // EXAMPLE 1
        String peks = "Find every variation of Pekka inside pekka";
        System.out.println(peks.replaceAll("[Pp]ekka", "Sexi-Pexi"));

        // EXAMPLE 2
        String change = "Change every char except 'e'";
        System.out.println(change.replaceAll("[^e]", "X"));

        // EXAMPLE 3
        String replaceSet = "Replace all a's and f's F's and 1,2,3";
        System.out.println(replaceSet.replaceAll("[aAfF1-3]", "X"));

        // EXAMPLE 4
        String caseSensitivity = "No CASE SENsIIITiviiiTyY";
        System.out.println(caseSensitivity.replaceAll("(?i)[iy]", "X"));

        // EXAMPLE 5
        String replaceNums = "213123210302";
        System.out.println(replaceNums.replaceAll("\\d", "X"));

        // EXAMPLE 6
        String escapeNonDigits = "I AM A 555 DIFIGIT";
        System.out.println(escapeNonDigits.replaceAll("\\D", "X"));

        // Example 7
        String removeWhiteSpaceFromAllPlaces = "I am a blank \t and newliner \n";
        System.out.println(removeWhiteSpaceFromAllPlaces.replaceAll("\\s", ""));

        // Example 8
        String removeSpecificWhiteSpace = "You need \t to remove \n specific whitespace";
        System.out.println(removeSpecificWhiteSpace.replaceAll("\n", ""));

        // Example 9
        String removeAllNonWhitespace = "We just want spaces \t here";
        System.out.println(removeAllNonWhitespace.replaceAll("\\S", ""));

        // Example 10
        String matchazLowerCase09AZandUnderScore = "___13adAB";
        System.out.println(matchazLowerCase09AZandUnderScore.replaceAll("\\w", "X"));

        // EXAMPLE 11
        String removesAllThatIsNotWhiteSpace = "JAg e en fattig bonddräng!";
        System.out.println(removesAllThatIsNotWhiteSpace.replaceAll("\\w", "X"));

        // EXAMPLE 12
        String replaceEverythinButWords = "Am I to be Replaced?";
        System.out.println(replaceEverythinButWords.replaceAll("\\W", "X"));

        // EXAMPLE 13, assumes words are separated by whitespace
        String matchWordBoundaries = "Am I to be Replaced?";
        System.out.println(matchWordBoundaries.replaceAll("\\b", "X"));
    }
}
