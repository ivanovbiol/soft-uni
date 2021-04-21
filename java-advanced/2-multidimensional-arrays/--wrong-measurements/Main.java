import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int rows = readIntNumber(scanner);
        int[][] matrix = readIntMatrix(scanner, rows);
        int[] coordinates = readIntArray(scanner);

        int[][] newMatrix = generateNewMatrix(matrix, coordinates);

        printMatrix(newMatrix);
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static int[][] readIntMatrix(Scanner scanner, int rows) {
        int[][] tempMatrix = new int[rows][];

        for (int index = 0; index < rows; index++) {
            tempMatrix[index] = readIntArray(scanner);
        }

        return tempMatrix;
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[][] generateNewMatrix(int[][] matrix, int[] coordinates) {
        int row = coordinates[0];
        int col = coordinates[1];
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        if (areValidCoordinates(row, col, matrix)) {
            int queryNumber = matrix[row][col];

            for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
                for (int colIndex = 0; colIndex < matrix[rowIndex].length; colIndex++) {

                    if (matrix[rowIndex][colIndex] == queryNumber) {
                        int sum = 0;

                        sum += areValidCoordinates(rowIndex - 1, colIndex, matrix, queryNumber)
                                ? matrix[rowIndex - 1][colIndex] : 0;
                        sum += areValidCoordinates(rowIndex + 1, colIndex, matrix, queryNumber)
                                ? matrix[rowIndex + 1][colIndex] : 0;
                        sum += areValidCoordinates(rowIndex, colIndex - 1, matrix, queryNumber)
                                ? matrix[rowIndex][colIndex - 1] : 0;
                        sum += areValidCoordinates(rowIndex, colIndex + 1, matrix, queryNumber)
                                ? matrix[rowIndex][colIndex + 1] : 0;

                        newMatrix[rowIndex][colIndex] = sum;
                    } else {
                        newMatrix[rowIndex][colIndex] = matrix[rowIndex][colIndex];
                    }
                }
            }
        }

        return newMatrix;
    }

    private static boolean areValidCoordinates(int row, int col, int[][] matrix) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[row].length;
    }

    private static boolean areValidCoordinates(int row, int col, int[][] matrix, int queryNumber) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[row].length
                && matrix[row][col] != queryNumber;
    }

    private static void printMatrix(int[][] matrix) {
        Arrays
                .stream(matrix)
                .forEach(element ->
                        System.out.println(
                                Arrays
                                        .stream(element)
                                        .mapToObj(String::valueOf)
                                        .collect(Collectors.joining(" "))));
    }
}
