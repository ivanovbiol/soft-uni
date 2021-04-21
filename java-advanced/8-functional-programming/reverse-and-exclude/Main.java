import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    private static final String SPACE_DELIMITER = " ";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = readIntegerList(scanner);
        int number = readIntNumber(scanner);

        Predicate<Integer> predicate = element -> element % number == 0;
        Consumer<List<Integer>> printer = list -> list
                .forEach(element -> System.out.print(element + SPACE_DELIMITER));

        numbers.removeIf(predicate);
        Collections.reverse(numbers);
        printer.accept(numbers);
    }

    private static List<Integer> readIntegerList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(SPACE_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}