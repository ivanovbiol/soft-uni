import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String STOP_COMMAND = "stop";
    private static final String PRINT_TEMPLATE = "%s -> %s";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resourcesMap = new LinkedHashMap<>();
        String resource = readStringInput(scanner);

        while (!STOP_COMMAND.equals(resource)) {
            int amount = readIntNumber(scanner);
            resourcesMap.putIfAbsent(resource, 0);

            int newAmount = resourcesMap.get(resource) + amount;
            resourcesMap.put(resource, newAmount);

            resource = readStringInput(scanner);
        }

        resourcesMap
                .forEach((key, value) -> System.out.printf(PRINT_TEMPLATE, key, value)
                        .println());
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}
