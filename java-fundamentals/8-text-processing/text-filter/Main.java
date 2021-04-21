import java.util.Scanner;

public class Main {
    private static final String ASTERISK = "*";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = readStringArray(scanner);
        String text = readStringInput(scanner);

        for (int index = 0; index < bannedWords.length; index++) {
            text = text.replaceAll(bannedWords[index], ASTERISK.repeat(bannedWords[index].length()));
        }

        System.out.println(text);
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split(",\\s+");
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
