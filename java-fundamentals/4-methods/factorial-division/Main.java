import java.util.Scanner;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNumber = readIntNumber(scanner);
        int secondNumber = readIntNumber(scanner);

        long firstFactorial = findFactorial(firstNumber);
        long secondFactorial = findFactorial(secondNumber);

        System.out.printf("%.2f", findDivisionOfTwoFactorials(firstFactorial, secondFactorial));

    }

    private static int readIntNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static long findFactorial(int number) {

        return LongStream
                .rangeClosed(1, number)
                .reduce(1, (long x, long y) -> x * y);

    }

    private static double findDivisionOfTwoFactorials(long firstFactorial, long secondFactorial) {

        return firstFactorial * 1.0 / secondFactorial;

    }
}