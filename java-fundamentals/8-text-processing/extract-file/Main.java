import java.util.Scanner;

public class Main {

    private static final String FILE_NAME_TEMPLATE = "File name: %s";
    private static final String EXTENSION_NAME_TEMPLATE = "File extension: %s";
    private static final String BACKSLASH_SIGH = "\\";
    private static final String PERIOD_SIGH = ".";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        String input = readInputString();

        String fileName = input.substring(input.lastIndexOf(BACKSLASH_SIGH) + 1, input.lastIndexOf(PERIOD_SIGH));
        String fileExtension = input.substring(input.lastIndexOf(PERIOD_SIGH) + 1);

        System.out.printf(FILE_NAME_TEMPLATE, fileName).println();
        System.out.printf(EXTENSION_NAME_TEMPLATE, fileExtension).println();
    }

    private static String readInputString() {
        return new Scanner(System.in).nextLine();
    }
}
