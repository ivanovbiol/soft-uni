import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String END = "end";
    private static final String PRINT_TEMPLATE = "%s %s is %d years old";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentList = readInputStudents(scanner);

        String city = readStringInput(scanner);

        System.out.println(getSortedStudents(studentList, city));
    }

    private static List<Student> readInputStudents(Scanner scanner) {
        List<Student> studentList = new ArrayList<>();

        String nextLine = readStringInput(scanner);

        while (!END.equals(nextLine)) {
            String[] inputStudentData = nextLine.split("\\s+");

            String firstName = inputStudentData[0];
            String lastName = inputStudentData[1];
            int age = Integer.parseInt(inputStudentData[2]);
            String hometown = inputStudentData[3];

            if (isExistingStudent(firstName, lastName, studentList)) {

                int index = findExistingStudentIndex(firstName, lastName, studentList);
                studentList.set(index, new Student(firstName, lastName, age, hometown));

            } else {
                studentList.add(new Student(firstName, lastName, age, hometown));
            }
            nextLine = readStringInput(scanner);
        }

        return studentList;
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static boolean isExistingStudent(String firstName, String lastName,
            List<Student> studentList) {
        return studentList
                .stream()
                .anyMatch(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName));
    }

    private static int findExistingStudentIndex(String firstName, String lastName,
            List<Student> studentList) {
        int studentIndex = 0;

        for (int index = 0; index < studentList.size(); index++) {
            if (studentList.get(index).getFirstName().equals(firstName) &&
                    studentList.get(index).getLastName().equals(lastName)) {
                studentIndex = index;
                break;
            }
        }

        return studentIndex;
    }

    private static String getSortedStudents(List<Student> studentList, String city) {
        StringBuilder stringBuilder = new StringBuilder();

        studentList
                .stream()
                .filter(e -> e.getHometown().equals(city))
                .forEach(e ->
                        stringBuilder
                                .append(String
                                        .format(PRINT_TEMPLATE, e.getFirstName(), e.getLastName(),
                                                e.getAge()))
                                .append(System.lineSeparator()));

        return stringBuilder.toString().trim();
    }
}
