import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    private static final String DELIMITER = ", ";
    private static final String PRINT_COUNT_TEMPLATE = "Count = %d";
    private static final String PRINT_SUM_TEMPLATE = "Sum = %d";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        int[] numbers = readIntArray(new Scanner(System.in));

        Function<int[], String> getCountOfElements = arr -> String
                .format(PRINT_COUNT_TEMPLATE, arr.length);

        System.out.println(getCountOfElements.apply(numbers));

        Function<int[], String> getSumOfElements = arr -> String.format(PRINT_SUM_TEMPLATE, Arrays.stream(arr).sum());

        System.out.println(getSumOfElements.apply(numbers));
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
