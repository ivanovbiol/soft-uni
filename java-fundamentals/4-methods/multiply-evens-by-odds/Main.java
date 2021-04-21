import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        int number = readIntNumber();

        System.out.println(getMultipleOfEvensAndOdds(number));

    }

    private static int readIntNumber() {

        return Math.abs(Integer.parseInt(new Scanner(System.in).nextLine()));

    }

    private static int getMultipleOfEvensAndOdds(int number) {

        int sumOfEvenDigits = getSumOfEvenDigits(number);
        int sumOfOddDigits = getSumOfOddDigits(number);

        return sumOfEvenDigits * sumOfOddDigits;

    }

    private static int getSumOfEvenDigits(int number) {

        int sum = 0;

        while (number > 0) {

            int digit = number % 10;
            sum += digit % 2 == 0 ? digit : 0;
            number /= 10;

        }

        return sum;

    }

    private static int getSumOfOddDigits(int number) {

        int sum = 0;

        while (number > 0) {

            int digit = number % 10;
            sum += digit % 2 == 1 ? digit : 0;
            number /= 10;

        }

        return sum;

    }
}