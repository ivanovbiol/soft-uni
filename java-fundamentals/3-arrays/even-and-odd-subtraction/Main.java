import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] intArray = readIntArray();

        System.out.println(getDifference(intArray));

    }

    private static int[] readIntArray() {

        return Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    private static int getDifference(int[] intArray) {

        int evenSum = Arrays.stream(intArray).filter(e -> e % 2 == 0).sum();
        int oddSum = Arrays.stream(intArray).filter(e -> e % 2 == 1).sum();

        return evenSum - oddSum;

    }
}