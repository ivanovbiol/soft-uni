import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = readIntNumber(scanner);
        int[][] matrix = readIntMatrix(scanner, matrixSize);

        int primaryDiagonalSum = findPrimaryDiagonalSum(matrix);
        int secondaryDiagonalSum = findSecondaryDiagonalSum(matrix);

        System.out.println(
                Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static int[][] readIntMatrix(Scanner scanner, int matrixSize) {
        int[][] matrix = new int[matrixSize][];

        for (int index = 0; index < matrix.length; index++) {
            matrix[index] = readIntArray(scanner);
        }

        return matrix;
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int findPrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = row; col <= row; col++) {
                sum += matrix[row][col];
            }
        }

        return sum;
    }

    private static int findSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = matrix[row].length - 1 - row; col >= matrix[row].length - 1 - row;
                    col--) {
                sum += matrix[row][col];
            }
        }

        return sum;
    }
}
