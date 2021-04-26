import java.util.Arrays;
import java.util.Scanner;

public class Engine {

    private static final String DELIMITER = "\\s+";
    private static final String END_COMMAND = "Let the Force be with you";

    public Engine() {
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int[] matrixCoordinates = readIntArray(scanner);
        int matrixRow = matrixCoordinates[0];
        int matrixCol = matrixCoordinates[1];

        Cell[][] matrix = new Cell[matrixRow][matrixCol];

        fillMatrix(matrix);

        long result = 0;

        String nextLine = readStringLine(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            int playerRow = Integer.parseInt(nextLine.split(DELIMITER)[0]);
            int playerCol = Integer.parseInt(nextLine.split(DELIMITER)[1]);

            int[] evilCoordinates = readIntArray(scanner);
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            setEvilPath(matrix, evilRow, evilCol);

            result += goThoughTheGalaxy(matrix, playerRow, playerCol);

            nextLine = scanner.nextLine();
        }

        System.out.println(result);
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void fillMatrix(Cell[][] matrix) {
        long counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Cell(i, j, counter);
                ++counter;
            }
        }
    }

    private String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    public static void setEvilPath(Cell[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (indexInBounds(matrix, evilRow, evilCol)) {
                matrix[evilRow][evilCol].setIsEvilPath(true);
            }
            evilRow--;
            evilCol--;
        }
    }

    public static boolean indexInBounds(Cell[][] matrix, int evilRow, int evilCol) {
        return evilRow >= 0 && evilRow < matrix.length && evilCol >= 0
                && evilCol < matrix[0].length;
    }

    public static long goThoughTheGalaxy(Cell[][] matrix, int row, int col) {
        long result = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (indexInBounds(matrix, row, col) && !matrix[row][col].getIsEvilPath()) {
                result += matrix[row][col].getValue();
            }
            col++;
            row--;
        }

        return result;
    }
}