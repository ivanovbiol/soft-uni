import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);
        GenericBox<String> genericBox = new GenericBox<>();

        int number = readIntNumber(scanner);

        while (number-- > 0) {
            String line = readStringLine(scanner);
            genericBox.add(line);
        }

        System.out.println(genericBox.toString());
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }
}