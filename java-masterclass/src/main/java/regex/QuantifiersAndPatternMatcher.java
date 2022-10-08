package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class QuantifiersAndPatternMatcher {
    public static void main(String[] args) {

        // EXAMPLE 1
        String quantifierString = "aafsfaFSFAfs1011010iiiiiiewE";
        System.out.println(quantifierString.replaceAll("i{3}", "X"));

        // EXAMPLE 2, Don't care of how many i's comes
        System.out.println(quantifierString.replaceAll("i+", "Y"));

        // EXAMPLE 3, no or any amount of i's
        System.out.println(quantifierString.replaceAll("^ai*", "X"));

        // EXAMPLE 4, match 2, 3 i's
        System.out.println(quantifierString.replaceAll("i{2,3}", "U"));

        // EXAMPLE 5, replace all 0 that are followed by any amount of i's and an e
        System.out.println(quantifierString.replaceAll("0+i*e", "Y"));

        // EXAMPLE 6 == PATTERN
        // Find all occurrences of <h2> tag
        StringBuilder htmlText = new StringBuilder("<h1>My Title</h1>");
        htmlText.append("<h2>UNDER-TEXT!</h2>");
        htmlText.append("<p>Para</p>");
        htmlText.append("<p>Antinatieantiantaa</p>");
        htmlText.append("<h2>Large boobs</h2>");

        String h2Pattern = "<?.h2>";
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        // EXAMPLE 7, Count occurrences and where they are, HINT: matcher needs to be reset
        matcher.reset();
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Found it @ char count: " + matcher.start() + " : " + matcher.end());
        }

        // EXAMPLE 8, GROUP PATTERN
        String h2GroupPattern = "(<?.h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);

        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        // EXAMPLE 9, GET ALL INFORMATION BETWEEN EACH INDIVIDUAL H2 TAG, HINT: ? is a lazy quantifier
        String h2GroupPattern2 = "(<h2>.*?</h2>)";
        Pattern groupPattern2 = Pattern.compile(h2GroupPattern2);
        Matcher groupMatcher2 = groupPattern2.matcher(htmlText);

        groupMatcher2.reset();

        while (groupMatcher2.find()) {
            System.out.println("Occurrence: " + groupMatcher2.group(1));
        }

        // Output just the text between the tags, HINT: the text will be in group 2
        String h2TextGroup = "(<h2>)(.*?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroup);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while (h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }


    }
}
