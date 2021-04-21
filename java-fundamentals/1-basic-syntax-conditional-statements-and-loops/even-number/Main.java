import java.util.Scanner;

public class Main {

    private static final String WARNING_STRING = "Please write an even number.";
    private static final String RESULT_STRING = "The number is: ";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // When we have several lines of input we need to add the Scanner as parameter
        // otherwise each method won't read the new lines of input
        int number = readInputNumber(scanner);

        while (isInvalidNumber(number)) {

            System.out.println(WARNING_STRING);

            number = readInputNumber(scanner);

        }

        System.out.println(getResult(number));

    }

    private static int readInputNumber(Scanner scanner) {

        return Math.abs(Integer.parseInt(scanner.nextLine()));

    }

    private static boolean isInvalidNumber(int number) {

        return number == 0 || number % 2 == 1;

    }

    private static String getResult(int number) {

        return RESULT_STRING + number;

    }
}