import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String SEARCH_COMMAND = "search";
    private static final String STOP_COMMAND = "stop";
    private static final String PRINT_TEMPLATE = "%s -> %s";
    private static final String CONTACT_DOES_NOT_EXIST = "Contact %s does not exist.";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        String input = readStringInput(scanner);
        Map<String, String> phonebook = new HashMap<>();

        while (!SEARCH_COMMAND.equals(input)) {
            String name = input.split("-")[0];
            String telephoneNumber = input.split("-")[1];

            phonebook.put(name, telephoneNumber);

            input = readStringInput(scanner);
        }

        String queryName = readStringInput(scanner);

        while (!STOP_COMMAND.equals(queryName)) {
            if (!phonebook.containsKey(queryName)) {
                System.out.printf(CONTACT_DOES_NOT_EXIST, queryName).println();
                queryName = readStringInput(scanner);
                continue;
            }

            System.out.printf(PRINT_TEMPLATE, queryName, phonebook.get(queryName)).println();

            queryName = readStringInput(scanner);
        }
    }
    
    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }
}