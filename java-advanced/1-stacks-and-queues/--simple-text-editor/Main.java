import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static final String APPEND_COMMAND = "1";
    public static final String ERASE_COMMAND = "2";
    public static final String RETURNS_COMMAND = "3";
    public static final String UNDOES_COMMAND = "4";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Stack<String> textBuilderStack = new Stack<>();
        int numberOfCommands = readIntNumber(scanner);

        String text = "";

        while (numberOfCommands-- > 0) {
            String nextLine = readStringInput(scanner);

            String command = nextLine.split("\\s+")[0];
            String textToAppend = "";

            switch (command) {
                case APPEND_COMMAND:
                    textToAppend = findTextToAppend(nextLine);
                    textBuilderStack.push(text);
                    text += textToAppend;
                    break;
                case ERASE_COMMAND:
                    textBuilderStack.push(text);
                    text = findTextSubstring(text, nextLine);
                    break;
                case RETURNS_COMMAND:
                    int queryElementPosition = findQueryElementPosition(nextLine);
                    System.out.println(text.charAt(queryElementPosition - 1));
                    break;
                case UNDOES_COMMAND:
                    text = textBuilderStack.pop();
                    break;
            }
        }
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static String findTextToAppend(String nextLine) {
        return nextLine.split("\\s+")[1];
    }

    private static String findTextSubstring(String text, String nextLine) {
        return text.substring(0,
                text.length() - Integer.parseInt(nextLine.split("\\s+")[1]));
    }

    private static int findQueryElementPosition(String nextLine) {
        return Integer.parseInt(nextLine.split("\\s+")[1]);
    }
}
