import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    private static final String BACK_COMMAND = "back";
    private static final String NO_PREVIOUS_URLS_MESSAGE = "no previous URLs";
    private static final String STOP_COMMAND = "Home";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();

        String stringURL = readStringInput(scanner);

        while (!STOP_COMMAND.equals(stringURL)) {
            if (!BACK_COMMAND.equals(stringURL)) {
                browser.push(stringURL);
                System.out.println(browser.peek());
            } else {
                if (browser.size() <= 1) {
                    System.out.println(NO_PREVIOUS_URLS_MESSAGE);
                } else {
                    browser.pop();
                    System.out.println(browser.peek());
                }
            }

            stringURL = readStringInput(scanner);
        }
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
