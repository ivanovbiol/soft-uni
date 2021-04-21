import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        String input = readStringInput();

        StringBuilder stringBuilder = removeDuplicateLetters(input);

        System.out.println(stringBuilder.toString());
    }

    private static String readStringInput() {
        return new Scanner(System.in).nextLine();
    }

    private static StringBuilder removeDuplicateLetters(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(input.charAt(0));

        char currentChar = 'a';
        char nextChar = 'a';

        for (int index = 1; index < input.length(); index++) {
            currentChar = input.charAt(index - 1);
            nextChar = input.charAt(index);

            if (nextChar != currentChar) {
                stringBuilder.append(nextChar);
            }
        }

        return stringBuilder;
    }
}
