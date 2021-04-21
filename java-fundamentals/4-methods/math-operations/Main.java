import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    private static final char DIVISION_OPERATOR = '/';
    private static final char MULTIPLICATION_OPERATOR = '*';
    private static final char SUMMING_OPERATOR = '+';
    private static final char SUBTRACTION_OPERATOR = '-';
    private static final String PRINT_TEMPLATE = "%.2f";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNumber = readIntNumber(scanner);
        char operator = readCharInput(scanner);
        int secondNumber = readIntNumber(scanner);

        DecimalFormat decimalFormat = new DecimalFormat("0.####");

        System.out.println(
                decimalFormat.format(
                        Double.valueOf(
                                String.format(PRINT_TEMPLATE,
                                        getResult(firstNumber, secondNumber, operator)))));

    }

    private static int readIntNumber(Scanner scanner) {

        return Math.abs(Integer.parseInt(scanner.nextLine()));

    }

    private static char readCharInput(Scanner scanner) {

        return scanner.nextLine().charAt(0);

    }

    private static double getResult(int firstNumber, int secondNumber, char operator) {

        double result = 0.0;

        switch (operator) {
            case DIVISION_OPERATOR:
                result = firstNumber * 1.0 / secondNumber;
                break;
            case MULTIPLICATION_OPERATOR:
                result = firstNumber * secondNumber;
                break;
            case SUMMING_OPERATOR:
                result = firstNumber + secondNumber;
                break;
            case SUBTRACTION_OPERATOR:
                result = firstNumber - secondNumber;
                break;
        }

        return result;

    }
}