import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final String NOT_FOUND_MESSAGE = "not found";
    public static final String POSITION_TEMPLATE = "%d %d";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int[] firstDimensions = readIntArray(scanner);
        int rows = firstDimensions[0];

        int[][] matrix = readMatrix(scanner, rows);

        int queryNumber = readIntNumber(scanner);

        printResult(matrix, queryNumber);
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[][] readMatrix(Scanner scanner, int rows) {
        int[][] tempMatrix = new int[rows][];

        for (int index = 0; index < rows; index++) {
            tempMatrix[index] = readIntArray(scanner);
        }

        return tempMatrix;
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void printResult(int[][] matrix, int queryNumber) {
        boolean numberIsNotPresent = true;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == queryNumber) {
                    System.out.printf(POSITION_TEMPLATE, row, col)
                            .println();
                    numberIsNotPresent = false;
                }

            }
        }

        if (numberIsNotPresent) {
            System.out.println(NOT_FOUND_MESSAGE);
        }
    }
}
