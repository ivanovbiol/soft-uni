import java.util.Scanner;

public class Main {

    private static final String OUTPUT_MESSAGE_FORMAT = "(%d, %d)";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int x1 = readIntNumber(scanner);
        int y1 = readIntNumber(scanner);
        int x2 = readIntNumber(scanner);
        int y2 = readIntNumber(scanner);

        System.out.println(getResult(x1, y1, x2, y2));

    }

    private static int readIntNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static String getResult(int x1, int y1, int x2, int y2) {

        int x1Abs = Math.abs(x1);
        int y1Abs = Math.abs(y1);
        int x2Abs = Math.abs(x2);
        int y2Abs = Math.abs(y2);

        return Math.max(x1Abs, y1Abs) <= Math.max(x2Abs, y2Abs) ?
                String.format(OUTPUT_MESSAGE_FORMAT, x1, y1)
                : String.format(OUTPUT_MESSAGE_FORMAT, x2, y2);

    }
}