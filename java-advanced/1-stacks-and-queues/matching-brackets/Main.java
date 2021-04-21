import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static final char OPENING_BRACKET = '(';
    private static final char CLOSING_BRACKET = ')';

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        String input = readStringInput();

        Stack<Integer> indexes = new Stack<>();

        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == OPENING_BRACKET) {
                indexes.push(index);
            } else if (input.charAt(index) == CLOSING_BRACKET) {
                System.out.println(input.substring(indexes.pop(), index + 1));
            }
        }
    }

    private static String readStringInput() {
        return new Scanner(System.in).nextLine();
    }
}
