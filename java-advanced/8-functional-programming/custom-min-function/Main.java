import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    private static final int ZERO = 0;
    private static final String SPACE_DELIMITER = "\\s+";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Function<int[], Integer> minNumberFunction =
                arr -> Arrays
                        .stream(arr)
                        .min()
                        .orElse(ZERO);

        int[] numbers = readIntArray();

        System.out.println(minNumberFunction.apply(numbers));
    }

    private static int[] readIntArray() {
        return Arrays
                .stream(new Scanner(System.in).nextLine().split(SPACE_DELIMITER))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
