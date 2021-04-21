import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String END_COMMAND = "end";
    private static final String COURSE_PRINT_TEMPLATE = "%s: %d";
    private static final String STUDENT_NAME_TEMPLATE = "-- %s";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> coursesMap = new HashMap<>();

        String nextLine = readStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            String courseName = nextLine.split("\\s+:\\s+")[0];
            String studentName = nextLine.split("\\s+:\\s+")[1];

            addCourseAndStudent(coursesMap, courseName, studentName);

            nextLine = readStringInput(scanner);
        }

        printCoursesAndStudents(coursesMap);
    }

    private static void addCourseAndStudent(Map<String, List<String>> coursesMap, String courseName,
            String studentName) {
        coursesMap.putIfAbsent(courseName, new ArrayList<>());

        if (!coursesMap.get(courseName).contains(studentName)) {
            coursesMap.get(courseName).add(studentName);
        }
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void printCoursesAndStudents(Map<String, List<String>> coursesMap) {
        coursesMap
                .entrySet()
                .stream()
                .sorted((first, second) ->
                        Integer.compare(second.getValue().size(), first.getValue().size()))
                .forEach(element -> {
                            System.out.printf(COURSE_PRINT_TEMPLATE,
                                    element.getKey(), element.getValue().size())
                                    .println();

                            element
                                    .getValue()
                                    .stream()
                                    .sorted()
                                    .forEach(student ->
                                            System.out.printf(STUDENT_NAME_TEMPLATE, student)
                                                    .println());
                        }
                );
    }
}
