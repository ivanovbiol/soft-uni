import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);
        GenericBox<Integer> genericBox = new GenericBox<>();

        int number = readIntNumber(scanner);

        while (number-- > 0) {
            int currentNumber = readIntNumber(scanner);
            genericBox.add(currentNumber);
        }

        int[] swapIndexes = readIntArray(scanner);
        genericBox.swap(swapIndexes[0], swapIndexes[1]);

        System.out.println(genericBox.toString());
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}