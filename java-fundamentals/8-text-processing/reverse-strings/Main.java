import java.util.Scanner;

public class Main {

    private static final String END_COMMAND = "end";
    private static final String PRINT_TEMPLATE = "%s = %s";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        String input = readStringInput(scanner);

        while (!END_COMMAND.equals(input)) {
            System.out.printf(
                    PRINT_TEMPLATE, input,
                    new StringBuilder(input).reverse().toString())
                    .println();

            input = readStringInput(scanner);
        }
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
