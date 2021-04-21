import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int number = readInputNumber();

        System.out.println(getResult(number));

    }

    private static int readInputNumber() {

        return Integer.parseInt(new Scanner(System.in).nextLine());

    }

    private static String getResult(int number) {

        int factorialSum = 0;

        int numberCopy = number;

        while (numberCopy > 0) {

            factorialSum += findFactorial(numberCopy % 10);

            numberCopy /= 10;
        }

        return factorialSum == number ? "yes" : "no";
    }

    private static int findFactorial(int digit) {

        if (digit <= 2) {
            return digit;
        }

        return digit * findFactorial(digit - 1);

    }
}