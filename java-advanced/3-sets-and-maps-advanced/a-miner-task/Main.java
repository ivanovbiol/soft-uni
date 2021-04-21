import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String STOP_COMMAND = "stop";
    private static final String PRINT_TEMPLATE = "%s -> %d";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        String resource = readStringInput(scanner);
        Map<String, Integer> resourcesMap = new LinkedHashMap<>();

        while (!STOP_COMMAND.equals(resource)) {
            int quantity = readIntNumber(scanner);

            resourcesMap.putIfAbsent(resource, 0);
            int newQuantity = resourcesMap.get(resource) + quantity;
            resourcesMap.put(resource, newQuantity);

            resource = readStringInput(scanner);
        }

        printResourcesMap(resourcesMap);
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void printResourcesMap(Map<String, Integer> resourcesMap) {
        resourcesMap
                .forEach((key, value) ->
                        System.out.printf(PRINT_TEMPLATE, key, value).println());
    }
}