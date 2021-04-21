import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private static final String END_COMMAND = "end";
    private static final String ADD_COMMAND = "add";
    private static final String MULTIPLY_COMMAND = "multiply";
    private static final String SUBTRACT_COMMAND = "subtract";
    private static final String PRINT_COMMAND = "print";
    private static final String SPACE_DELIMITER = " ";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = readIntArray(scanner);
        String command = readStringLine(scanner);

        while (!command.equals(END_COMMAND)) {

            switch (command) {
                case ADD_COMMAND:
                    numbers = addToElements(numbers);
                    break;
                case MULTIPLY_COMMAND:
                    numbers =  multiplyElements(numbers);
                    break;
                case SUBTRACT_COMMAND:
                    numbers = subtractFromElements(numbers);
                    break;
                case PRINT_COMMAND:
                    printElements(numbers);
                    break;
            }

            command = readStringLine(scanner);
        }
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(SPACE_DELIMITER))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private static int[] addToElements(int[] numbers) {
        Function<int[], int[]> addFunction = arr ->
                Arrays
                        .stream(arr)
                        .map(e -> e += 1)
                        .toArray();

       return addFunction.apply(numbers);
    }

    private static int[] multiplyElements(int[] numbers) {
        Function<int[], int[]> multiplyFunction = arr ->
                Arrays
                        .stream(arr)
                        .map(e -> e *= 2)
                        .toArray();

        return multiplyFunction.apply(numbers);
    }

    private static int[] subtractFromElements(int[] numbers) {
        Function<int[], int[]> subtractFunction = arr ->
                Arrays
                        .stream(arr)
                        .map(e -> e -= 1)
                        .toArray();

        return subtractFunction.apply(numbers);
    }

    private static void printElements(int[] numbers) {
        Consumer<int[]> print = arr ->
                System.out.println(
                        Arrays
                                .stream(numbers)
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining(SPACE_DELIMITER)));

        print.accept(numbers);
    }
}
