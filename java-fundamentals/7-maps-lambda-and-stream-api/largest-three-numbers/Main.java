import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        List<Integer> numbers =
                Arrays
                        .stream(new Scanner(System.in).nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .sorted(Collections.reverseOrder())
                        .collect(Collectors.toList());

        if (numbers.size() < 3) {
            System.out.println(
                    numbers
                            .stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(" ")));
        } else {
            System.out.println(
                    numbers
                            .stream()
                            .limit(3)
                            .map(String::valueOf)
                            .collect(Collectors.joining(" ")));
        }
    }
}
