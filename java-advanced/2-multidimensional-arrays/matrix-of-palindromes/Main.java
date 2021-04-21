import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        int[] matrixParameters = readIntArray();
        int rows = matrixParameters[0];
        int cols = matrixParameters[1];

        String[][] matrix = createMatrix(rows, cols);

        printMatrix(matrix);
    }

    private static int[] readIntArray() {
        return Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String[][] createMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String currentCellData = (char) (97 + row) + " " + (char) (97 + row);
            Arrays.fill(matrix[row], currentCellData);
            matrix[row][0] = matrix[row][0].replace(" ", String.valueOf((char) (97 + row)));
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                char nextLetterInAlphabet = (char) (matrix[row][col].charAt(0) + col);
                matrix[row][col] = matrix[row][col]
                        .replace(" ", String.valueOf(nextLetterInAlphabet));
            }
        }

        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        Arrays
                .stream(matrix)
                .forEach(element ->
                        System.out.println(
                                String.join(" ", element)));
    }
}
