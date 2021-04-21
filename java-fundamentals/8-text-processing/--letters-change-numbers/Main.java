import java.util.Scanner;

public class Main {

    private static final char FIRST_CAPITAL_LETTER = 'A' - 1;
    private static final char FIRST_NON_CAPITAL_LETTER = 'a' - 1;
    private static final String TOTAL_SUM_PRINT_TEMPLATE = "%.2f";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        String[] input = readStringArray();

        double totalSum = 0;

        for (String currentString : input) {
            int number = findNumber(currentString);

            char firstChar = currentString.charAt(0);
            char secondChar = currentString.charAt(currentString.length() - 1);

            double tempResult = findTempResult(number, firstChar);
            tempResult = findTempResult(tempResult, secondChar);

            totalSum += tempResult;
        }

        System.out.printf(
                TOTAL_SUM_PRINT_TEMPLATE, totalSum)
                .println();
    }

    private static String[] readStringArray() {
        return new Scanner(System.in).nextLine().split("\\s+");
    }

    private static int findNumber(String input) {
        return Integer.parseInt(
                input.substring(1, input.length() - 1));
    }

    private static double findTempResult(int number, char currentChar) {
        if (Character.isUpperCase(currentChar)) {
            return number * 1.0 / (currentChar - FIRST_CAPITAL_LETTER);
        } else if (Character.isLowerCase(currentChar)) {
            return number * (currentChar - FIRST_NON_CAPITAL_LETTER);
        }
        return 0;
    }

    private static double findTempResult(double tempResult, char currentChar) {
        if (Character.isUpperCase(currentChar)) {
            return tempResult - (currentChar - FIRST_CAPITAL_LETTER);
        } else if (Character.isLowerCase(currentChar)) {
            return tempResult + (currentChar - FIRST_NON_CAPITAL_LETTER);
        }
        return 0;
    }
}
