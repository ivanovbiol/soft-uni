import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String PRINT_TEMPLATE = "Found %s at %s";
    private static final String END_COMMAND = "find";
    private static final char TREASURE_START_AND_STOP_SYMBOL = '&';
    private static final char COORDINATES_START_SYMBOL = '<';
    private static final char COORDINATES_STOP_SYMBOL = '>';

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int[] intArray = readIntArray(scanner);

        String encryptedMessage = readStringInput(scanner);

        while (!END_COMMAND.equals(encryptedMessage)) {
            String decryptedMessage = decryptMessage(encryptedMessage, intArray);

            String treasure = decryptedMessage
                    .substring(decryptedMessage.indexOf(TREASURE_START_AND_STOP_SYMBOL) + 1,
                            decryptedMessage.lastIndexOf(TREASURE_START_AND_STOP_SYMBOL));
            String coordinates = decryptedMessage
                    .substring(decryptedMessage.indexOf(COORDINATES_START_SYMBOL) + 1,
                            decryptedMessage.lastIndexOf(COORDINATES_STOP_SYMBOL));

            System.out.printf(PRINT_TEMPLATE, treasure, coordinates).println();

            encryptedMessage = readStringInput(scanner);
        }
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static String decryptMessage(String encryptedMessage, int[] intArray) {
        StringBuilder stringBuilder = new StringBuilder();

        int intArrayIndex = 0;
        for (int index = 0; index < encryptedMessage.length(); index++) {
            if (intArrayIndex == intArray.length) {
                intArrayIndex = 0;
            }

            stringBuilder
                    .append((char) (encryptedMessage.charAt(index) - intArray[intArrayIndex++]));
        }

        return stringBuilder.toString();
    }
}
