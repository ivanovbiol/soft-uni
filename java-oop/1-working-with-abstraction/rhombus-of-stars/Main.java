import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        int number = readIntNumber();

        RhombusPrinter rhombusPrinter = new RhombusPrinter(number);

        rhombusPrinter.printRhombus();
    }

    private static int readIntNumber() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
}