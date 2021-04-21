import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String PATTERN_TYPE_A = "A";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        String[] instructions = readStringArray();

        int matrixSize = Integer.parseInt(instructions[0]);
        String patternType = instructions[1];

        int[][] matrix = null;

        if (patternType.equals(PATTERN_TYPE_A)) {
            matrix = fillMatrixUsingPatternTypeA(matrixSize);
        } else {
            matrix = fillMatrixUsingPatternTypeB(matrixSize);
        }

        printMatrix(matrix);
    }

    private static String[] readStringArray() {
        return new Scanner(System.in).nextLine().split(",\\s+");
    }

    private static int[][] fillMatrixUsingPatternTypeA(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        int counter = 1;

        for (int col = 0; col < matrixSize; col++) {
            for (int row = 0; row < matrixSize; row++) {
                matrix[row][col] = counter++;
            }
        }

        return matrix;
    }

    private static int[][] fillMatrixUsingPatternTypeB(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        int counter = 1;
        int rowNumber = 0;

        while (rowNumber < matrixSize) {

            if (rowNumber % 2 == 0) {
                for (int row = 0; row < matrixSize; row++) {
                    matrix[row][rowNumber] = counter++;
                }
            } else {
                for (int row = matrixSize - 1; row >= 0; row--) {
                    matrix[row][rowNumber] = counter++;
                }
            }

            ++rowNumber;
        }

        return matrix;
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
