import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private static final String SPACE_DELIMITER = "\\s+";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        List<Integer> numbers = readIntegerList(new Scanner(System.in));

        Function<List<Integer>, Integer> function = integerList -> {
            int minNumber = Integer.MAX_VALUE;
            int minNumberIndex = -1;

            for (int index = 0; index < numbers.size(); index++) {
                if (numbers.get(index) <= minNumber) {
                    minNumber = numbers.get(index);
                    minNumberIndex = index;
                }
            }
            return minNumberIndex;
        };

        System.out.println(function.apply(numbers));
    }

    private static List<Integer> readIntegerList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(SPACE_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}