import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final String EQUAL_MESSAGE = "equal";
    public static final String NOT_EQUAL_MESSAGE = "not equal";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int[] firstDimensions = readIntArray(scanner);
        int firstWidth = firstDimensions[0];
        int firstLength = firstDimensions[1];
        int[][] firstMatrix = readMatrix(scanner, firstWidth);

        int[] secondDimensions = readIntArray(scanner);
        int secondWidth = secondDimensions[0];
        int secondLength = secondDimensions[1];
        int[][] secondMatrix = readMatrix(scanner, secondWidth);

        if (firstWidth != secondWidth || firstLength != secondLength) {
            System.out.println(NOT_EQUAL_MESSAGE);
        } else if (matricesHaveDifferentValues(firstMatrix, secondMatrix)) {
            System.out.println(NOT_EQUAL_MESSAGE);
        } else {
            System.out.println(EQUAL_MESSAGE);
        }
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[][] readMatrix(Scanner scanner, int width) {
        int[][] tempMatrix = new int[width][];

        for (int index = 0; index < width; index++) {
            tempMatrix[index] = readIntArray(scanner);
        }

        return tempMatrix;
    }

    private static boolean matricesHaveDifferentValues(int[][] firstMatrix, int[][] secondMatrix) {
        boolean areDifferent = false;

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                areDifferent = firstMatrix[row][col] != secondMatrix[row][col];
                if (areDifferent) {
                    break;
                }
            }
        }

        return areDifferent;
    }
}
