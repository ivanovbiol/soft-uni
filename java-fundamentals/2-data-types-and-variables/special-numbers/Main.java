import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String OUTPUT_TEMPLATE = "%d -> %s";

    public static void main(String[] args) {

        int number = Integer.parseInt(new Scanner(System.in).nextLine());

        printResult(number);

    }

    private static void printResult(int number) {

        for (int i = 1; i <= number; i++) {

            int sumOfDigits = Arrays
                    .stream(String.valueOf(i).split(""))
                    .mapToInt(Integer::valueOf)
                    .sum();

            boolean isSpecialNumber = sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11;

            String booleanMessage = String.valueOf(isSpecialNumber).substring(0, 1).toUpperCase() + String.valueOf(isSpecialNumber).substring(1).toLowerCase();

            System.out.printf(OUTPUT_TEMPLATE, i, booleanMessage).println();

        }

    }
}