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

            studentList.add(new Student(firstName, lastName, age, hometown));

            nextLine = readStringInput(scanner);
        }

        return studentList;
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
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
