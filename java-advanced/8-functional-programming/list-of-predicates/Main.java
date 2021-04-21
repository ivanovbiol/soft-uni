import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final String SPACE_DELIMITER = " ";
    private static final int ONE = 1;

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int number = readIntNumber(scanner);
        int[] numbersArr = readIntArray(scanner);

        IntPredicate intPredicate = element -> {
            for (int index = 0; index < numbersArr.length; index++) {
                if (element % numbersArr[index] != 0) {
                    return false;
                }
            }
            return true;
        };

        System.out.println(
                IntStream
                        .rangeClosed(ONE, number)
                        .filter(intPredicate)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(SPACE_DELIMITER)));
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(SPACE_DELIMITER))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}