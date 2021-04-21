import java.util.Scanner;

public class Main {

    private static final char EXPLOSION_CHAR = '>';

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        String input = readStringInput();

        StringBuilder stringBuilder = removeExplodedLetters(input);

        System.out.println(stringBuilder.toString());
    }

    private static String readStringInput() {
        return new Scanner(System.in).nextLine();
    }

    private static StringBuilder removeExplodedLetters(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        int bombPower = 0;

        for (int index = 0; index < input.length(); index++) {

            char currentChar = input.charAt(index);

            if (currentChar == EXPLOSION_CHAR) {
                bombPower += Character.getNumericValue(input.charAt(index + 1));
                stringBuilder.append(EXPLOSION_CHAR);
            } else if (bombPower == 0) {
                stringBuilder.append(currentChar);
            } else {
                bombPower--;
            }

        }

        return stringBuilder;
    }
}
