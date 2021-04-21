import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String END_COMMAND = "Nuke it from orbit";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int[] matrixParameters = readIntArray(scanner);
        int row = matrixParameters[0];
        int col = matrixParameters[1];
        List<List<Integer>> matrixAsList = generateMatrix(row, col);

        String nextLine = readStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            int bombRow = Integer.parseInt(nextLine.split("\\s+")[0]);
            int bombCol = Integer.parseInt(nextLine.split("\\s+")[1]);
            int bombRadius = Integer.parseInt(nextLine.split("\\s+")[2]);

            explodeBomb(matrixAsList, bombRow, bombCol, bombRadius);

            nextLine = readStringInput(scanner);
        }

        printMatrix(matrixAsList);
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static List<List<Integer>> generateMatrix(int row, int col) {
        List<List<Integer>> matrixAsList = new LinkedList<>();

        int counter = 0;

        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            matrixAsList.add(new LinkedList<>());
            for (int colIndex = 0; colIndex < col; colIndex++) {
                matrixAsList.get(rowIndex).add(++counter);
            }
        }

        return matrixAsList;
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void explodeBomb(List<List<Integer>> matrixAsList, int bombRow, int bombCol,
            int bombRadius) {
        for (int index = bombRow - bombRadius; index <= bombRow + bombRadius; index++) {
            if (areValidCoordinates(index, bombCol, matrixAsList) && index != bombRow) {
                matrixAsList.get(index).remove(bombCol);
            }
        }

        for (int index = bombCol + bombRadius; index >= bombCol - bombRadius; index--) {
            if (areValidCoordinates(bombRow, index, matrixAsList)) {
                matrixAsList.get(bombRow).remove(index);
            }
        }

        matrixAsList.removeIf(List::isEmpty);
    }

    private static boolean areValidCoordinates(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(List<List<Integer>> matrixAsList) {
        matrixAsList
                .forEach(element ->
                        System.out.println(
                                element
                                        .stream()
                                        .map(String::valueOf)
                                        .collect(Collectors.joining(" "))));
    }
}