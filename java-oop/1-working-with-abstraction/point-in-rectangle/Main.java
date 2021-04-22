import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String DELIMITER = "\\s+";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int[] rectangleCoordinates = readIntArray(scanner);
        int bottomLeftX = rectangleCoordinates[0];
        int bottomLeftY = rectangleCoordinates[1];
        int topRightX = rectangleCoordinates[2];
        int topRightY = rectangleCoordinates[3];

        Point firstPoint = new Point(bottomLeftX, bottomLeftY);
        Point secondPoint = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(firstPoint, secondPoint);

        int number = readIntNumber(scanner);

        while (number-- > 0) {
            int[] currentPointCoordinates = readIntArray(scanner);
            int currentPointX = currentPointCoordinates[0];
            int currentPointY = currentPointCoordinates[1];

            Point currentPoint = new Point(currentPointX, currentPointY);

            System.out.println(rectangle.contains(currentPoint));
        }
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}