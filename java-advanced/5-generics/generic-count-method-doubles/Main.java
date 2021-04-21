import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);
        GenericBox<Double> genericBox = new GenericBox<>();

        int number = readIntNumber(scanner);

        while (number-- > 0) {
            double currentNumber = readDoubleNumber(scanner);
            genericBox.add(currentNumber);
        }

        double queryNumber = readDoubleNumber(scanner);

        System.out.println(genericBox.compareTo(queryNumber));
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static double readDoubleNumber(Scanner scanner) {
        return Double.parseDouble(scanner.nextLine());
    }
}