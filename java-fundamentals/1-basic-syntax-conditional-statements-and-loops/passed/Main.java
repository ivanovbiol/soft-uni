import java.util.Scanner;

public class Main {

    private static final String PASSED_MESSAGE = "Passed!";
    private static final double MINIMAL_THRESHOLD = 3.0;

    public static void main(String[] args) {

        double grade = readGrade();

        printResult(grade);

    }

    private static double readGrade() {

        return Double.parseDouble(new Scanner(System.in).nextLine());

    }

    private static void printResult(double grade) {

        if (grade >= MINIMAL_THRESHOLD) {
            System.out.println(PASSED_MESSAGE);
        }

    }
}