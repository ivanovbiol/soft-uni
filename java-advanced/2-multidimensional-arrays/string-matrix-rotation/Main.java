import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static final String END_COMMAND = "END";
    private static final String EMPTY_SPACE = " ";
    private static final int MAX_ROTATION_DEGREES = 360;
    private static final int ZERO_ROTATION_DEGREES = 0;
    private static final int NINETY_ROTATION_DEGREES = 90;
    private static final int HUNDRED_AND_EIGHTY_ROTATION_DEGREES = 180;
    private static final int TWO_HUNDRED_AND_SEVENTY_ROTATION_DEGREES = 270;

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        List<String> matrixElements = new LinkedList<>();

        String rotationCommand = readStringInput(scanner);
        int rotationDegrees = findRotationDegrees(rotationCommand);

        String nextLine = readStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            matrixElements.add(nextLine);
            nextLine = readStringInput(scanner);
        }

        int matrixRows = findMatrixRows(matrixElements);
        int matrixCols = findMatrixCols(matrixElements);
        String[][] matrix = fillMatrix(matrixElements, matrixRows, matrixCols);

        while (rotationDegrees >= MAX_ROTATION_DEGREES) {
            rotationDegrees -= MAX_ROTATION_DEGREES;
        }

        switch (rotationDegrees) {
            case ZERO_ROTATION_DEGREES:
                printMatrix(matrix);
                break;
            case NINETY_ROTATION_DEGREES:
                printNinetyDegreesReversedMatrix(matrix, matrixCols);
                break;
            case HUNDRED_AND_EIGHTY_ROTATION_DEGREES:
                printHundredAndEightyDegreesReversedMatrix(matrix);
                break;
            case TWO_HUNDRED_AND_SEVENTY_ROTATION_DEGREES:
                printTwoHundredAndSeventyDegreesReversedMatrix(matrix, matrixCols);
                break;
        }
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static int findRotationDegrees(String rotationCommand) {
        return Integer.parseInt(
                rotationCommand
                        .substring(rotationCommand.indexOf('(') + 1, rotationCommand.indexOf(')')));
    }

    private static int findMatrixRows(List<String> matrixElements) {
        return matrixElements.size();
    }

    private static int findMatrixCols(List<String> matrixElements) {
        return matrixElements
                .stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("")
                .length();
    }

    private static String[][] fillMatrix(List<String> matrixElements, int matrixRows,
            int matrixCols) {
        String[][] matrix = new String[matrixRows][matrixCols];

        for (int row = 0; row < matrixRows; row++) {
            String currentMatrixElement = matrixElements.remove(0);

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] =
                        col < currentMatrixElement.length() ?
                                String.valueOf(currentMatrixElement.charAt(col)) :
                                EMPTY_SPACE;
            }
        }

        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        Arrays
                .stream(matrix)
                .forEach(element ->
                        System.out.println(
                                String.join("", element)));
    }

    private static void printNinetyDegreesReversedMatrix(String[][] matrix, int matrixCols) {
        for (int col = 0; col < matrixCols; col++) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printHundredAndEightyDegreesReversedMatrix(String[][] matrix) {
        Stack<String> tempStack = new Stack<>();

        Arrays
                .stream(matrix)
                .forEach(element ->
                        tempStack.push(
                                new StringBuilder(String.join("", element))
                                        .reverse()
                                        .toString()));

        while (!tempStack.isEmpty()) {
            System.out.println(tempStack.pop());
        }
    }

    private static void printTwoHundredAndSeventyDegreesReversedMatrix(String[][] matrix,
            int matrixCols) {
        for (int col = matrixCols - 1; col >= 0; col--) {
            for (int row = 0; row < matrix.length; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
