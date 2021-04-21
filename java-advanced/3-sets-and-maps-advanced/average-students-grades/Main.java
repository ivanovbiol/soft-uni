import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

    private static final String PRINT_TEMPLATE = "%s -> %s (avg: %.2f)";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = readIntNumber(scanner);
        Map<String, List<Double>> studentGradesMap = generateDoubleMap(numberOfLines, scanner);
        printStudentGradesMap(studentGradesMap);
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static Map<String, List<Double>> generateDoubleMap(int numberOfLines, Scanner scanner) {
        Map<String, List<Double>> studentGradesMap = new TreeMap<>();

        while (numberOfLines-- > 0) {
            String nextLine = readStringInput(scanner);
            String studentName = nextLine.split("\\s+")[0];
            double studentGrade = Double.parseDouble(nextLine.split("\\s+")[1]);

            studentGradesMap.putIfAbsent(studentName, new ArrayList<>());
            studentGradesMap.get(studentName).add(studentGrade);
        }

        return studentGradesMap;
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void printStudentGradesMap(Map<String, List<Double>> studentGradesMap) {
        studentGradesMap
                .forEach((key, value) -> {
                    String allGradesForAStudent =
                            value
                                    .stream()
                                    .map(new DecimalFormat("#.00")::format)
                                    .collect(Collectors.joining(" "));
                    double averageGrade =
                            value
                                    .stream()
                                    .mapToDouble(Double::valueOf)
                                    .average()
                                    .orElse(0);

                    System.out.printf(
                            PRINT_TEMPLATE, key, allGradesForAStudent, averageGrade)
                            .println();
                });
    }
}