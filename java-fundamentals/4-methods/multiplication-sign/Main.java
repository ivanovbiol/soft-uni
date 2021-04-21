import java.util.Scanner;

public class Main {

    private static final String POSITIVE_MESSAGE = "positive";
    private static final String NEGATIVE_MESSAGE = "negative";
    private static final String ZERO_MESSAGE = "zero";


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNumber = readIntNumber(scanner);
        int secondNumber = readIntNumber(scanner);
        int thirdNumber = readIntNumber(scanner);

        System.out.println(getResult(firstNumber, secondNumber, thirdNumber));

    }

    private static int readIntNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static String getResult(int firstNumber, int secondNumber, int thirdNumber) {

        if (firstNumber == 0 || secondNumber == 0 || thirdNumber == 0) {
            return ZERO_MESSAGE;
        } else if (firstNumber < 0 || secondNumber < 0 || thirdNumber < 0) {

            if (firstNumber < 0 && secondNumber < 0 && thirdNumber > 0||
                    firstNumber < 0 && thirdNumber < 0 && secondNumber > 0 ||
                    secondNumber < 0 && thirdNumber < 0 && firstNumber > 0) {
                return POSITIVE_MESSAGE;
            }

            return NEGATIVE_MESSAGE;
        } else {
            return POSITIVE_MESSAGE;
        }

    }
}