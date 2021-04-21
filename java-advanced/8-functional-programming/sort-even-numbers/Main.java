import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class Main {

    private static final String DELIMITER = ", ";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        int[] numbers = readIntArray(new Scanner(System.in));

        IntPredicate evenNumbersPredicate = number -> number % 2 == 0;

        printEvenNumbers(numbers, evenNumbersPredicate);

        printSortedEvenNumbers(numbers, evenNumbersPredicate);
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void printEvenNumbers(int[] numbers, IntPredicate evenNumbersPredicate) {
        System.out.println(
                Arrays
                        .stream(numbers)
                        .filter(evenNumbersPredicate)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(DELIMITER)));
    }

    private static void printSortedEvenNumbers(int[] numbers, IntPredicate evenNumbersPredicate) {
        System.out.println(
                Arrays
                        .stream(numbers)
                        .filter(evenNumbersPredicate)
                        .sorted()
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(DELIMITER)));
    }
}
