import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = readIntNumber(scanner);

        List<Student> students = readStudentsList(scanner, numberOfStudents);

        System.out.println(filterStudentsAndReturnResult(scanner, students));
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static List<Student> readStudentsList(Scanner scanner, int numberOfStudents) {
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String[] studentData = readStudentData(scanner);

            students.add(new Student(studentData[0], Integer.parseInt(studentData[1])));
        }

        return students;
    }

    private static String[] readStudentData(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static String filterStudentsAndReturnResult(Scanner scanner, List<Student> students) {
        StringBuilder stringBuilder = new StringBuilder();

        students
                .stream()
                .filter(e -> e.getAge() > 30)
                .sorted(Comparator.comparing(Student::getName))
                .forEach(
                        e -> stringBuilder
                                .append(String.format("%s - %d", e.getName(), e.getAge()))
                                .append(System.lineSeparator()));

        return stringBuilder.toString().trim();
    }
}
