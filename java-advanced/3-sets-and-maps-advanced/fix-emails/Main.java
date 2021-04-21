import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String STOP_COMMAND = "stop";
    private static final String PRINT_TEMPLATE = "%s -> %s";
    private static final List<String> INVALID_EMAIL_DOMAINS = List.of("us", "uk", "com");

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailsMap = new LinkedHashMap<>();
        String name = readStringInput(scanner);

        while (!STOP_COMMAND.equals(name)) {
            String email = readStringInput(scanner);

            if (isValidEmail(email)) {
                emailsMap.put(name, email);
            }

            name = readStringInput(scanner);
        }

        printEmailsMap(emailsMap);
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static boolean isValidEmail(String email) {
        return !INVALID_EMAIL_DOMAINS.contains(email.substring(email.lastIndexOf(".") + 1));
    }

    private static void printEmailsMap(Map<String, String> emailsMap) {
        emailsMap
                .forEach((key, value) ->
                        System.out.printf(PRINT_TEMPLATE, key, value).println());
    }
}