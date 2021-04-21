import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String SWAP_COMMAND = "swap";
    private static final String END_COMMAND = "END";
    private static final String INVALID_INPUT_COMMAND = "Invalid input!";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int[] matrixParameters = readIntArray(scanner);
        int rows = matrixParameters[0];
        int cols = matrixParameters[1];

        String[][] matrix = readStringMatrix(scanner, rows);

        String nextLine = readStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            if (isValidInput(nextLine, rows, cols)) {
                String[] nextLineParameters = splitStringIntoParameters(nextLine);

                int rowOne = Integer.parseInt(nextLineParameters[1]);
                int colOne = Integer.parseInt(nextLineParameters[2]);
                int rowTwo = Integer.parseInt(nextLineParameters[3]);
                int colTwo = Integer.parseInt(nextLineParameters[4]);

                exchangeValuesInMatrix(matrix, rowOne, colOne, rowTwo, colTwo);
                printMatrix(matrix);
            } else {
                System.out.println(INVALID_INPUT_COMMAND);
            }

            nextLine = readStringInput(scanner);
        }
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String[][] readStringMatrix(Scanner scanner, int rows) {
        String[][] matrix = new String[rows][];

        for (int index = 0; index < matrix.length; index++) {
            matrix[index] = readStringArray(scanner);
        }

        return matrix;
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static boolean isValidInput(String nextLine, int rows, int cols) {
        String[] nextLineParameters = nextLine.split("\\s+");

        if (nextLineParameters.length != 5) {
            return false;
        }

        if (!SWAP_COMMAND.equals(nextLineParameters[0])) {
            return false;
        }

        int rowOne;
        int colOne;
        int rowTwo;
        int colTwo;

        try {
            rowOne = Integer.parseInt(nextLineParameters[1]);
            colOne = Integer.parseInt(nextLineParameters[2]);
            rowTwo = Integer.parseInt(nextLineParameters[3]);
            colTwo = Integer.parseInt(nextLineParameters[4]);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }

        return rowOne >= 0 && rowTwo >= 0 && colOne < cols && colTwo < cols;
    }

    private static String[] splitStringIntoParameters(String nextLine) {
        return nextLine.split("\\s+");
    }

    private static void exchangeValuesInMatrix(String[][] matrix, int rowOne, int colOne, int rowTwo,
            int colTwo) {
        String tempValue = matrix[rowOne][colOne];
        matrix[rowOne][colOne] = matrix[rowTwo][colTwo];
        matrix[rowTwo][colTwo] = tempValue;
    }

    private static void printMatrix(String[][] matrix) {
        Arrays
                .stream(matrix)
                .forEach(element ->
                        System.out.println(
                                String.join(" ", element)));
    }
}
