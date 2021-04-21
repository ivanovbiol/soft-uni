import java.util.Scanner;

public class Main {

    private static final String OUTPUT_MESSAGE_TEMPLATE = "%s is %s type";
    private static final String END = "END";
    private static final String TRUE = "true";
    private static final String FALSE = "false";
    private static final String BOOLEAN = "boolean";
    private static final String STRING = "string";
    private static final String CHARACTER = "character";
    private static final String FLOATING_POINT = "floating point";
    private static final String INTEGER = "integer";


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String nextLine = readNextLine(scanner);

        while (!END.equals(nextLine)) {

            System.out.println(getResult(nextLine));

            nextLine = readNextLine(scanner);
        }

    }

    private static String readNextLine(Scanner scanner) {

        return scanner.nextLine();

    }

    private static String getResult(String input) {

        if (input.equalsIgnoreCase(TRUE) || input.equalsIgnoreCase(FALSE)) {

            return String.format(OUTPUT_MESSAGE_TEMPLATE, input, BOOLEAN);

        } else if (input.length() == 1 && !isInteger(input) && !isFloatingPoint(input)) {

            return String.format(OUTPUT_MESSAGE_TEMPLATE, input, CHARACTER);

        } else if (isInteger(input)) {

            return String.format(OUTPUT_MESSAGE_TEMPLATE, input, INTEGER);

        } else if (isFloatingPoint(input)) {

            return String.format(OUTPUT_MESSAGE_TEMPLATE, input, FLOATING_POINT);

        } else {

            return String.format(OUTPUT_MESSAGE_TEMPLATE, input, STRING);

        }

    }

    private static boolean isFloatingPoint(String input) {

        try {

            double number = Double.parseDouble(input);
            return true;

        } catch (NumberFormatException exception) {

            return false;

        }

    }

    private static boolean isInteger(String input) {

        try {

            int number = Integer.parseInt(input);
            return true;

        } catch (NumberFormatException exception) {

            return false;
            
        }

    }
}