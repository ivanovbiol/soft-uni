import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String SUM_PRINT_TEMPLATE = "Sum = %d";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int[] matrixParameters = readIntArray(scanner);
        int rows = matrixParameters[0];

        int[][] matrix = readIntMatrix(scanner, rows);

        int newMatrixSize = 3;

        int[][] maxMatrix = new int[newMatrixSize][];
        int maxMatrixSum = 0;

        for (int row = 0; row <= matrix.length - newMatrixSize; row++) {
            for (int col = 0; col <= matrix[row].length - newMatrixSize; col++) {
                int[][] nextSubMatrix = findSubMatrix(matrix, row, col, newMatrixSize);
                int nextSubMatrixSum = findSubMatrixSum(nextSubMatrix);

                if (nextSubMatrixSum > maxMatrixSum) {
                    maxMatrixSum = nextSubMatrixSum;
                    maxMatrix = nextSubMatrix;
                }
            }
        }

        printResult(maxMatrixSum, maxMatrix);
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[][] readIntMatrix(Scanner scanner, int rows) {
        int[][] matrix = new int[rows][];

        for (int index = 0; index < matrix.length; index++) {
            matrix[index] = readIntArray(scanner);
        }

        return matrix;
    }

    private static int[][] findSubMatrix(int[][] matrix, int row, int col, int newMatrixSize) {
        int[][] nextSubMatrix = new int[newMatrixSize][newMatrixSize];

        int iterationSteps = newMatrixSize;
        int newSubMatrixRows = 0;

        while (iterationSteps-- > 0) {
            nextSubMatrix[newSubMatrixRows] =
                    Arrays.copyOfRange(
                            matrix[row + newSubMatrixRows], col, (col + newMatrixSize));

            ++newSubMatrixRows;
        }

        return nextSubMatrix;
    }

    private static int findSubMatrixSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            sum += Arrays.stream(matrix[row]).sum();
        }

        return sum;
    }

    private static void printResult(int maxMatrixSum, int[][] maxMatrix) {
        System.out.printf(SUM_PRINT_TEMPLATE, maxMatrixSum).println();

        Arrays
                .stream(maxMatrix)
                .forEach(element ->
                        System.out.println(
                                Arrays
                                        .stream(element)
                                        .mapToObj(String::valueOf)
                                        .collect(Collectors.joining(" "))));
    }
}
