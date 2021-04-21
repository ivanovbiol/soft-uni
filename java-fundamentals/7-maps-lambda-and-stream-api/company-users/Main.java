import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String END_COMMAND = "End";
    private static final String EMPLOYEE_PRINT_TEMPLATE = "-- %s";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companyMap = new HashMap<>();

        String nextLine = readStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            String[] companyData = nextLine.split("\\s*->\\s*");

            String companyName = companyData[0];
            String employeeId = companyData[1];

            companyMap.putIfAbsent(companyName, new LinkedList<>());

            if (idIsNotPresent(companyMap, companyName, employeeId)) {
                companyMap.get(companyName).add(employeeId);
            }

            nextLine = readStringInput(scanner);
        }

        companyMap
                .entrySet()
                .stream()
                .sorted((first, second) -> first.getKey().compareTo(second.getKey()))
                .forEach(element -> {
                    System.out.println(element.getKey());

                    element
                            .getValue()
                            .forEach(id ->
                                    System.out.printf(
                                            EMPLOYEE_PRINT_TEMPLATE, id)
                                            .println());
                });
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static boolean idIsNotPresent(Map<String, List<String>> companyMap, String companyName,
            String employeeId) {
        return !companyMap.get(companyName).contains(employeeId);
    }
}
