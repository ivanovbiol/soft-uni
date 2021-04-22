import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Engine {

    private static final String DELIMITER = "\\s+";
    private static final String CREATE_COMMAND = "Create";
    private static final String SHOW_COMMAND = "Show";
    private static final String EXIT_COMMAND = "Exit";

    private List<Student> studentsList;

    public Engine() {
        this.setStudentsList(new ArrayList<Student>());
    }

    // Getter
    private List<Student> getStudentsList() {
        return this.studentsList;
    }

    // Setter
    private void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        String inputLine = readStringLine(scanner);

        while (!inputLine.equals(EXIT_COMMAND)) {
            String[] studentInput = inputLine.split(DELIMITER);
            String command = studentInput[0];

            switch (command) {
                case CREATE_COMMAND:
                    createAndAddStudentInList(studentInput);
                    break;
                case SHOW_COMMAND:
                    findStudentAndPrintInfo(studentInput);
                    break;
            }

            inputLine = readStringLine(scanner);
        }
    }

    private String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split(DELIMITER);
    }

    private void createAndAddStudentInList(String[] studentInput) {
        String studentName = studentInput[1];
        int studentAge = Integer.parseInt(studentInput[2]);
        double studentGrade = Double.parseDouble(studentInput[3]);

        this.getStudentsList().add(new Student(studentName, studentAge, studentGrade));
    }

    private void findStudentAndPrintInfo(String[] studentInput) {
        String studentName = studentInput[1];
        Predicate<Student> predicate = student -> student.getStudentName().equals(studentName);

        if (this.getStudentsList().stream().anyMatch(predicate)) {
            this.getStudentsList()
                    .stream()
                    .filter(predicate)
                    .map(Student::toString)
                    .forEach(System.out::println);
        }
    }
}
