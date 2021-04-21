import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        char[] input = readCharArray(scanner);

        StringBuilder numbers = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder symbols = new StringBuilder();

        for (Character current : input) {
            appendChar(current, numbers, letters, symbols);
        }

        printResult(numbers, letters, symbols);
    }

    private static char[] readCharArray(Scanner scanner) {
        return scanner.nextLine().toCharArray();
    }

    private static void appendChar(Character current, StringBuilder numbers, StringBuilder letters,
            StringBuilder symbols) {
        if (Character.isDigit(current)) {
            numbers.append(current);
        } else if (Character.isAlphabetic(current)) {
            letters.append(current);
        } else {
            symbols.append(current);
        }
    }

    private static void printResult(StringBuilder numbers, StringBuilder letters,
            StringBuilder symbols) {
        System.out.println(numbers.toString());
        System.out.println(letters.toString());
        System.out.println(symbols.toString());
    }
}
