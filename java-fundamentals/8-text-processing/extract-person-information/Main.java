import java.util.Scanner;

public class Main {

    private static final String PRINT_TEMPLATE = "%s is %s years old.";
    private static final char NAME_START_CHAR = '@';
    private static final char NAME_END_CHAR = '|';
    private static final char AGE_START_CHAR = '#';
    private static final char AGE_END_CHAR = '*';

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int number = readIntNumber(scanner);

        while (number-- > 0) {
            String input = readStringInput(scanner);

            String name = input
                    .substring(input.indexOf(NAME_START_CHAR) + 1, input.indexOf(NAME_END_CHAR));
            String age = input
                    .substring(input.indexOf(AGE_START_CHAR) + 1, input.indexOf(AGE_END_CHAR));

            System.out.printf(PRINT_TEMPLATE, name, age).println();
        }
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
