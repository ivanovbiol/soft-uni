import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String VOWELS_STRING = "aeiouAEIOU";

    public static void main(String[] args) {

        int number = readIntNumber();

        calculateAndPrintPascalTriangle(number);

    }

    private static int readIntNumber() {

        return Integer.parseInt(new Scanner(System.in).nextLine());

    }

    private static void calculateAndPrintPascalTriangle(int number) {

        if (number == 0) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        int[] firstIntArray = new int[]{1};

        stringBuilder.append(Arrays
                .toString(firstIntArray)
                .replace("[", " ")
                .replace("]", " ")
                .trim());

        int[] tempArray = firstIntArray;

        for (int length = 2; length <= number; length++) {

            int[] nextArray = new int[length];

            nextArray[0] = 1;
            nextArray[nextArray.length - 1] = 1;

            for (int nextArrayPosition = 1; nextArrayPosition < nextArray.length - 1;
                    nextArrayPosition++) {

                nextArray[nextArrayPosition] =
                        tempArray[nextArrayPosition - 1] + tempArray[nextArrayPosition];

            }

            tempArray = nextArray;

            stringBuilder
                    .append(System.lineSeparator())
                    .append(Arrays
                            .stream(nextArray)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" ")));

        }

        System.out.println(stringBuilder.toString());

    }
}