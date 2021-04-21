import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String ARE_IDENTICAL_TEMPLATE = "Arrays are identical. Sum: %d";
    private static final String ARE_NOT_IDENTICAL_TEMPLATE = "Arrays are not identical. Found difference at %d index.";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] firstIntArray = readIntArray(scanner);
        int[] secondIntArray = readIntArray(scanner);

        System.out.println(getResult(firstIntArray, secondIntArray));

    }

    private static int[] readIntArray(Scanner scanner) {

        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    private static String getResult(int[] firstIntArray, int[] secondIntArray) {

        if (firstIntArray.length != secondIntArray.length) {

            return firstIntArray.length > secondIntArray.length ?
                    String.format(ARE_NOT_IDENTICAL_TEMPLATE, firstIntArray.length - 1) :
                    String.format(ARE_NOT_IDENTICAL_TEMPLATE, secondIntArray.length - 1);

        }

        for (int index = 0; index < firstIntArray.length; index++) {

            if (firstIntArray[index] != secondIntArray[index]) {

                return String.format(ARE_NOT_IDENTICAL_TEMPLATE, index);

            }

        }

        return String.format(ARE_IDENTICAL_TEMPLATE, Arrays.stream(firstIntArray).sum());

    }
}