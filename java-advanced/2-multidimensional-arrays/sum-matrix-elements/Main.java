import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int[] parameters = readIntArray(scanner);

        int[][] matrix = readIntMatrix(scanner, parameters[0]);

        System.out.println(parameters[0]);
        System.out.println(parameters[1]);
        System.out.println(findSumOfElements(matrix));
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

    private static int findSumOfElements(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }

        return sum;
    }
}
