import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);
        GenericBox<Integer> genericBox = new GenericBox<>();

        int number = readIntNumber(scanner);

        while (number-- > 0) {
            int lineNumber = readIntNumber(scanner);
            genericBox.add(lineNumber);
        }

        System.out.println(genericBox.toString());
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}