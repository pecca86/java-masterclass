package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamLambdaChallenge1 {
    public static void main(String[] args) {

        // CHALLENGE NO 1
        Runnable runnable = () -> {
            String s = "Split me up!";
            String[] split = s.split(" ");
            Arrays.stream(split)
                    .forEach(System.out::println);
        };

        runnable.run();

        // CHALLENGE NO 2, 3, 4 & 5
        System.out.println(every2ndChar("Jagvillhafitta", (s) -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }));

        // CHALLENGE NO 6 & 7
        Supplier<String> lovin = () -> "I Love cock!";
        System.out.println(lovin.get());

        // CHALLENGE NO 9, 10 & 11
        List<String> names = Arrays.asList(
                "polle",
                "araben",
                "Alfons",
                "homon",
                "sexuell",
                "nöjd",
                "kåtbock",
                "båtkock"
        );
        List<String> sortedName = names.stream()
                .map(n -> n.substring(0, 1).toUpperCase() + n.substring(1))
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        sortedName.forEach(System.out::println);

        // CHALLENGE NO 12
        Long aNames = sortedName.stream()
                .filter(n -> n.startsWith("A"))
                .count();
        System.out.println("Count of names starting with 'A': " + aNames);
    }

    public static String every2ndChar(String s, Function<String, String> printEverySecond) {
        return printEverySecond.apply(s);
    }
}
