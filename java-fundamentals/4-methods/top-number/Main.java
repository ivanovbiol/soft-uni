import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        int number = readIntNumber();

        getAndPrintResult(number);

    }

    private static int readIntNumber() {

        return Integer.parseInt(new Scanner(System.in).nextLine());

    }

    private static void getAndPrintResult(int number) {

        IntStream
                .rangeClosed(1, number)
                .forEach(e -> {
                    if (isTopInteger(e)) {
                        System.out.println(e);
                    }
                });

    }

    private static boolean isTopInteger(int number) {

        return hasAtLeastOneOddDigit(number) && sumOfDigitsIsDivisibleByEight(number);

    }

    private static boolean hasAtLeastOneOddDigit(int number) {

        return Arrays
                .stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 1)
                .count() > 0;
        
    }

    private static boolean sumOfDigitsIsDivisibleByEight(int number) {

        return Arrays
                .stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .sum() % 8 == 0;

    }
}