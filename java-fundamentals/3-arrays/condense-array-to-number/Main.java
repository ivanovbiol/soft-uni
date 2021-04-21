import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] intArray = readIntArray();

        System.out.println(getResult(intArray));

    }

    private static int[] readIntArray() {

        return Arrays
                .stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    private static int getResult(int[] intArray) {

        if (intArray.length == 1) {
            return intArray[0];
        }

        int sum = 0;

        while (intArray.length != 1) {

            int[] condensed = new int[intArray.length - 1];

            for (int i = 0; i < intArray.length - 1; i++) {

                condensed[i] = intArray[i] + intArray[i + 1];

            }

            intArray = condensed;

            if (condensed.length == 1) {
                sum = condensed[0];
            }

        }

        return sum;

    }
}