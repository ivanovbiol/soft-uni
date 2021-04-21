import java.util.Scanner;

public class Main {

    private static final String ADD_OPERATION = "add";
    private static final String MULTIPLY_OPERATION = "multiply";
    private static final String SUBTRACT_OPERATION = "subtract";
    private static final String DIVIDE_OPERATION = "divide";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = readStringInput(scanner);
        int firstNumber = readIntNumber(scanner);
        int secondNumber = readIntNumber(scanner);

        processAndPrintResult(command, firstNumber, secondNumber);

    }

    private static String readStringInput(Scanner scanner) {

        return scanner.nextLine();

    }

    private static int readIntNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static void processAndPrintResult(String command, int firstNumber, int secondNumber) {

        int result = 0;

        switch (command) {
            case ADD_OPERATION:
                result = firstNumber + secondNumber;
                break;
            case SUBTRACT_OPERATION:
                result = firstNumber - secondNumber;
                break;
            case MULTIPLY_OPERATION:
                result = firstNumber * secondNumber;
                break;
            case DIVIDE_OPERATION:
                result = firstNumber / secondNumber;
                break;
        }

        System.out.println(result);
        
    }
}