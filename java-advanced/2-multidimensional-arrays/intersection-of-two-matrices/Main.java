import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String ASTERISK_SIGN = "*";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int rows = readIntNumber(scanner);
        int cols = readIntNumber(scanner);

        String[][] firstMatrix = readMatrix(scanner, rows);
        String[][] secondMatrix = readMatrix(scanner, rows);

        printResultingMatrix(firstMatrix, secondMatrix, cols);
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String[][] readMatrix(Scanner scanner, int rows) {
        String[][] tempMatrix = new String[rows][];

        for (int index = 0; index < rows; index++) {
            tempMatrix[index] = readStringArray(scanner);
        }

        return tempMatrix;
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static void printResultingMatrix(String[][] firstMatrix, String[][] secondMatrix, int cols) {
        String[][] resultingMatrix = new String[firstMatrix.length][];

        for (int row = 0; row < firstMatrix.length; row++) {
            resultingMatrix[row] = new String[cols];

            for (int col = 0; col < firstMatrix[row].length; col++) {
                resultingMatrix[row][col] =
                        firstMatrix[row][col].equals(secondMatrix[row][col]) ?
                                firstMatrix[row][col] : ASTERISK_SIGN;
            }
        }

        Arrays
                .stream(resultingMatrix)
                .forEach(e -> System.out.println(String.join(" ", e)));
    }
}
