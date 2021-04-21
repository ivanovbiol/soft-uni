import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

    private static final String PRINT_TEMPLATE = "%s -> %.2f";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> gradesMap = new HashMap<>();

        int number = readIntNumber(scanner);

        while (number-- > 0) {
            String studentName = readStringInput(scanner);
            double grade = readDoubleNumber(scanner);

            gradesMap.putIfAbsent(studentName, new ArrayList<>());
            gradesMap.get(studentName).add(grade);
        }

        printResult(gradesMap);
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static double readDoubleNumber(Scanner scanner) {
        return Double.parseDouble(scanner.nextLine());
    }

    private static void printResult(Map<String, List<Double>> gradesMap) {
        gradesMap
                .entrySet()
                .stream()
                .filter(element ->
                        findAverageGrade(element) >= 4.5)
                .sorted((first, second) -> {
                            int result = Double.compare(findAverageGrade(second),
                                    findAverageGrade(first));
                            if (result == 0) {
                                result = second.getKey().compareTo(first.getKey());
                            }
                            return result;
                        }
                ).forEach(entry ->
                System.out.printf(
                        PRINT_TEMPLATE,
                        entry.getKey(), findAverageGrade(entry))
                        .println());
    }

    private static double findAverageGrade(Entry<String, List<Double>> gradesMap) {
        return gradesMap
                .getValue()
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
    }
}
