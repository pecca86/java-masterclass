package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStreamDemo {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList(
                "Pekka", "Göran",
                "Kalle", "Adolf",
                "Maki", "Arnold",
                "Olle", "Jupiter",
                "Bolle", "Challo"
        );

        List<String> sortedNames = stringList.stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 4)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        sortedNames.forEach(System.out::println);

        // ALTERNATIVE WAY
        Stream<String> ioNumberStream = Stream.of("P1", "P2", "P3", "O11");
        Stream<String> inNumberStream = Stream.of("M2", "M5", "M6", "O11");
        // Concat method is static, so cannot be used in chain, but it's result can be chained
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("====== PEEKING =======");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());
    }
}
