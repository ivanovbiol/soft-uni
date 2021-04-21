import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String SPACE_DELIMITER = " ";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        List<Integer> numbers = readIntegerList();

        Comparator<Integer> customComparator = ((first, second) -> {
            if (first % 2 == 0 && second % 2 == 0) {
                return first.compareTo(second);
            } else if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            } else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            }
            return first.compareTo(second);
        });

        printListOfNumbers(numbers, customComparator);
    }

    private static List<Integer> readIntegerList() {
        return Arrays
                .stream(new Scanner(System.in).nextLine().split(SPACE_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void printListOfNumbers(List<Integer> numbers,
            Comparator<Integer> customComparator) {
        System.out.println(
                numbers
                        .stream()
                        .sorted(customComparator)
                        .map(String::valueOf)
                        .collect(Collectors.joining(SPACE_DELIMITER)));

    }
}