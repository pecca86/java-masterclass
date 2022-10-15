package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {
    public static void main(String[] args) {
        // CHALLENGE 1
        String c1 = "I want a ball";
        System.out.println(c1.matches("I want a.*"));

        // CHALLENGE 2
        String replaceBlanksWithUnderScore = "Replcae all mf blanks bitch !";
        System.out.println(replaceBlanksWithUnderScore.replaceAll("\\s", "_"));

        // CHALLENGE 3
        String matchAll = "aaabccccccccdddefffg";
        System.out.println(matchAll.matches("a*b*c*d*e*f*g*"));
        System.out.println(matchAll.matches("[adbcdefg]+"));
        System.out.println(matchAll.matches("[a-g]+"));

        // CHALLENGE 4, Match no other string than matchAll string
        System.out.println(matchAll.matches("^a{3}bc{8}d{3}ef{3}g$"));

        // CHALLENGE 5, First n amount of letters, then a . and after that n amount of digits
        System.out.println("adsda.1203021".matches("^[a-zA-Z]+\\.[0-9]*$"));
        System.out.println("adsda.1203021".matches("^\\w+\\.\\d+$"));

        // CHALLENGE 6, Print all digits in string
        String ch6 = "abcd.135vdw.7defl.999";
        String ch6Group = "[A-Za-z]+\\.(\\d*)";
        Pattern pattern = Pattern.compile(ch6Group);
        Matcher matcher = pattern.matcher(ch6);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        // CHALLENGE 7, String now contains \t tabs and a \n new line
        String ch7 = "asddsa.44\ttretet.47\torekk.444\n";
//        Pattern pattern7 = Pattern.compile("[A-Za-z]+\\.(\\d*)[\t|\n]");
        Pattern pattern7 = Pattern.compile("[A-Za-z]+\\.(\\d*)\\s");
        Matcher matcher7 = pattern7.matcher(ch7);
        while (matcher7.find()) {
            System.out.println(matcher7.group(1));
        }

        // CHALLENGE 8
        String ch8 = "asdd.44\ttretet.47\torekk.444\n";
        Pattern pat8 = Pattern.compile("[A-Za-z]+\\.(\\d*)\\s");
        Matcher mat8 = pat8.matcher(ch8);
        while (mat8.find()) {
            System.out.println(mat8.group(1) + ": @ indexes " + mat8.start(1) + " - " + (mat8.end(1) -1));
        }

        // CHALLENGE 9, Extract digits from within {}
        String curly = "{0,2},{0,5},{1,3},{2,4}";
        Pattern pattern9 = Pattern.compile("\\{([0-9],[0-9])},*");
        Matcher matcher9 = pattern9.matcher(curly);
        while (matcher9.find()) {
            System.out.println(matcher9.group(1));
        }

        // CHALLENGE 10, Match 5 digits
        System.out.println("11111".matches("\\d{5}"));

        // CHALLENGE 11, Match number and number with dash
        String reggie = "^\\d{5}(-\\d{4})?$";
        System.out.println("11111".matches(reggie));
        System.out.println("11111-1111".matches(reggie));
        System.out.println("11111-1111-12313".matches(reggie));

    }
}
