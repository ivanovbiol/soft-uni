import java.util.Scanner;

public class Main {

    private static final char QUEEN_SIGN = 'q';
    private static final int MATRIX_ROWS = 8;
    private static final String PRINT_TEMPLATE = "%d %d";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        char[][] matrix = readCharMatrix(MATRIX_ROWS);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (isQueenCurrentChar(matrix, row, col)) {
                    if (isValidQueenPosition(matrix, row, col)) {
                        System.out.printf(PRINT_TEMPLATE, row, col).println();
                        break;
                    }
                }

            }
        }
    }

    private static char[][] readCharMatrix(int rows) {
        Scanner scanner = new Scanner(System.in);
        char[][] tempMatrix = new char[rows][];

        for (int index = 0; index < rows; index++) {
            tempMatrix[index] = scanner.nextLine()
                    .replaceAll(" ", "")
                    .toCharArray();
        }

        return tempMatrix;
    }

    private static boolean isQueenCurrentChar(char[][] matrix, int row, int col) {
        return matrix[row][col] == QUEEN_SIGN;
    }

    private static boolean isValidQueenPosition(char[][] matrix, int row, int col) {
        // left from the Queen
        for (int index = col - 1; index >= 0; index--) {
            if (isQueenCurrentChar(matrix, row, index)) {
                return false;
            }
        }

        // right from the Queen
        for (int index = col + 1; index < matrix[row].length; index++) {
            if (isQueenCurrentChar(matrix, row, index)) {
                return false;
            }
        }

        // up from the Queen
        for (int index = row - 1; index >= 0; index--) {
            if (isQueenCurrentChar(matrix, index, col)) {
                return false;
            }
        }

        // down from the Queen
        for (int index = row + 1; index < matrix[row].length; index++) {
            if (isQueenCurrentChar(matrix, index, col)) {
                return false;
            }
        }

        int tempColIndex = col;

        // upper left diagonal from the Queen
        for (int index = row - 1; index >= 0; index--) {
            if (--tempColIndex >= 0) {
                if (isQueenCurrentChar(matrix, index, tempColIndex)) {
                    return false;
                }
            } else {
                break;
            }
        }
        tempColIndex = col;

        // upper right diagonal from the Queen
        for (int index = row - 1; index >= 0; index--) {
            if (++tempColIndex < matrix[index].length) {
                if (isQueenCurrentChar(matrix, index, tempColIndex)) {
                    return false;
                }
            } else {
                break;
            }
        }
        tempColIndex = col;

        // lower right diagonal from the Queen
        for (int index = row + 1; index < matrix.length; index++) {
            if (++tempColIndex < matrix[index].length) {
                if (isQueenCurrentChar(matrix, index, tempColIndex)) {
                    return false;
                }
            } else {
                break;
            }
        }
        tempColIndex = col;

        // lower left diagonal from the Queen
        for (int index = row + 1; index < matrix.length; index++) {
            if (--tempColIndex >= 0) {
                if (isQueenCurrentChar(matrix, index, tempColIndex)) {
                    return false;
                }
            } else {
                break;
            }
        }

        return true;
    }
}
