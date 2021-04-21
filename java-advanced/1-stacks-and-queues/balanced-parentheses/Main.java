import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static final String YES_MESSAGE = "YES";
    public static final String NO_MESSAGE = "NO";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        String input = readStringInput();
        Stack<Character> parenthesesStack = new Stack<>();

        boolean areBalanced = true;

        for (int index = 0; index < input.length(); index++) {
            char currentBracket = input.charAt(index);

            if (isOpeningBracket(currentBracket)) {
                parenthesesStack.push(input.charAt(index));
            } else if (isClosingBracket(currentBracket)) {
                if (lastElementsIsOpeningBracket(currentBracket, parenthesesStack)) {
                    parenthesesStack.pop();
                } else {
                    areBalanced = false;
                    break;
                }
            }
        }

        System.out.println(areBalanced ? YES_MESSAGE : NO_MESSAGE);
    }

    private static String readStringInput() {
        return new Scanner(System.in).nextLine();
    }

    private static boolean isOpeningBracket(char currentBracket) {
        return currentBracket == '(' || currentBracket == '[' || currentBracket == '{';
    }

    private static boolean isClosingBracket(char currentBracket) {
        return currentBracket == ')' || currentBracket == ']' || currentBracket == '}';
    }

    private static boolean lastElementsIsOpeningBracket(char currentBracket,
            Stack<Character> parenthesesStack) {
        if (parenthesesStack.isEmpty()) {
            return false;
        }

        switch (currentBracket) {
            case ')':
                return parenthesesStack.peek() == '(';
            case ']':
                return parenthesesStack.peek() == '[';
            case '}':
                return parenthesesStack.peek() == '{';
        }

        return false;
    }
}
