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

        int[] firstDiagonal = findFirstDiagonal(matrix, rows);
        int[] secondDiagonal = findSecondDiagonal(matrix, rows);

        printIntArray(firstDiagonal);
        printIntArray(secondDiagonal);
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

    private static int[] findFirstDiagonal(int[][] matrix, int rows) {
        int[] diagonal = new int[rows];

        for (int index = 0; index < matrix.length; index++) {
            diagonal[index] = matrix[index][index];
        }

        return diagonal;
    }

    private static int[] findSecondDiagonal(int[][] matrix, int rows) {
        int[] diagonal = new int[rows];
        int counter = 0;

        for (int index = matrix.length - 1; index >= 0; index--) {
            diagonal[counter] = matrix[index][counter];
            counter++;
        }

        return diagonal;
    }

    private static void printIntArray(int[] intArray) {
        System.out.println(
                Arrays
                        .stream(intArray)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "))
        );
    }
}
