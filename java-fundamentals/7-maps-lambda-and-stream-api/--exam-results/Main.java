import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String END_COMMAND = "exam finished";
    private static final String BANNED_STUDENT_MESSAGE = "-banned";
    private static final String SPLIT_SIGN = "-";
    private static final String STUDENT_SUBMISSIONS_COUNT_PRINT_TEMPLATE = "%s | %d";
    private static final String LANGUAGE_SUBMISSIONS_COUNT_PRINT_TEMPLATE = "%s - %d";
    private static final String RESULTS_TEMPLATE = "Results:";
    private static final String SUBMISSIONS_TEMPLATE = "Submissions:";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> studentsPointsMap = new HashMap<>();
        Map<String, Integer> languageSubmissionsMap = new HashMap<>();

        String input = readStringInput(scanner);

        while (!END_COMMAND.equals(input)) {
            if (!input.contains(BANNED_STUDENT_MESSAGE)) {
                addStudentPointAndLanguageSubmissions(studentsPointsMap, languageSubmissionsMap,
                        input);
            } else {
                removeStudent(studentsPointsMap, input);
            }

            input = readStringInput(scanner);
        }

        printResult(studentsPointsMap, languageSubmissionsMap);
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void addStudentPointAndLanguageSubmissions(
            Map<String, Integer> studentsPointsMap, Map<String, Integer> languageSubmissionsMap,
            String input) {
        String studentName = input.split(SPLIT_SIGN)[0];
        String language = input.split(SPLIT_SIGN)[1];
        int points = Integer.parseInt(input.split(SPLIT_SIGN)[2]);

        studentsPointsMap.putIfAbsent(studentName, points);

        if (studentsPointsMap.get(studentName) < points) {
            studentsPointsMap.put(studentName, points);
        }

        languageSubmissionsMap.putIfAbsent(language, 0);
        int newSubmissionsCount = languageSubmissionsMap.get(language) + 1;
        languageSubmissionsMap.put(language, newSubmissionsCount);
    }

    private static void removeStudent(Map<String, Integer> studentsPointsMap, String input) {
        String studentName = input.substring(0, input.indexOf('-'));
        studentsPointsMap.remove(studentName);
    }

    private static void printResult(Map<String, Integer> studentsPointsMap,
            Map<String, Integer> languageSubmissionsMap) {
        System.out.println(RESULTS_TEMPLATE);

        studentsPointsMap
                .entrySet()
                .stream()
                .sorted((firstElement, secondElement) -> {
                    int result = Integer
                            .compare(secondElement.getValue(), firstElement.getValue());
                    if (result == 0) {
                        result = firstElement.getKey().compareTo(secondElement.getKey());
                    }
                    return result;
                }).forEach(element ->
                System.out.printf(
                        STUDENT_SUBMISSIONS_COUNT_PRINT_TEMPLATE,
                        element.getKey(), element.getValue())
                        .println());

        System.out.println(SUBMISSIONS_TEMPLATE);

        languageSubmissionsMap
                .entrySet()
                .stream()
                .sorted((firstElement, secondElement) -> {
                    int result = Integer.compare(secondElement.getValue(), firstElement.getValue());
                    if (result == 0) {
                        result = firstElement.getKey().compareTo(secondElement.getKey());
                    }
                    return result;
                }).forEach(element ->
                System.out.printf(
                        LANGUAGE_SUBMISSIONS_COUNT_PRINT_TEMPLATE,
                        element.getKey(), element.getValue())
                        .println());
    }
}
