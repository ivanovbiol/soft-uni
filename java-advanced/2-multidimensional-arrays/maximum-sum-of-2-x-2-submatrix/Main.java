import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int[] parameters = readIntArray(scanner);
        int rows = parameters[0];

        int[][] matrix = readIntMatrix(scanner, rows);

        int biggestSum = 0;
        int[][] biggestMatrix = new int[2][];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {

                int[][] firstTempMatrix = findTempMatrix(matrix, row, col);
                int[][] secondTempMatrix = findTempMatrix(matrix, row, col + 1);

                int firstTempMatrixSum = findMatrixSum(firstTempMatrix);
                int secondTempMatrixSum = findMatrixSum(secondTempMatrix);

                if (firstTempMatrixSum > biggestSum) {
                    biggestSum = firstTempMatrixSum;
                    biggestMatrix = firstTempMatrix;
                }

                if (secondTempMatrixSum > biggestSum) {
                    biggestSum = secondTempMatrixSum;
                    biggestMatrix = secondTempMatrix;
                }
            }
        }

        printResult(biggestMatrix, biggestSum);
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[][] readIntMatrix(Scanner scanner, int rows) {
        int[][] tempMatrix = new int[rows][];

        for (int index = 0; index < rows; index++) {
            tempMatrix[index] = readIntArray(scanner);
        }

        return tempMatrix;
    }

    private static int[][] findTempMatrix(int[][] matrix, int row, int col) {
        int[][] tempMatrix = new int[2][2];

        tempMatrix[0][0] = matrix[row][col];
        tempMatrix[0][1] = matrix[row][col + 1];
        tempMatrix[1][0] = matrix[row + 1][col];
        tempMatrix[1][1] = matrix[row + 1][col + 1];

        return tempMatrix;
    }

    private static int findMatrixSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }

        return sum;
    }

    private static void printResult(int[][] matrix, int sum) {
        Arrays
                .stream(matrix)
                .forEach(element ->
                        System.out.println(
                                Arrays
                                        .stream(element)
                                        .mapToObj(String::valueOf)
                                        .collect(Collectors.joining(" "))));

        System.out.println(sum);
    }
}
