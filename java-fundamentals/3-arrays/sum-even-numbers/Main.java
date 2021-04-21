import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] numbersArray = readNumbersArray();

        System.out.println(getEvenNumbersSum(numbersArray));

    }

    private static int[] readNumbersArray() {

        return Arrays
                .stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    private static int getEvenNumbersSum(int[] numbersArray) {

        return Arrays.stream(numbersArray).filter(e -> e % 2 == 0).sum();

    }
}