import java.util.Scanner;

public class Main {

    private static final String PASSED_MESSAGE = "Passed!";
    private static final String FAILED_MESSAGE = "Failed!";
    private static final double MINIMAL_THRESHOLD = 3.0;

    public static void main(String[] args) {

        double grade = readGrade();

        System.out.println(getResult(grade));

    }

    private static double readGrade() {

        return Double.parseDouble(new Scanner(System.in).nextLine());

    }

    private static String getResult(double grade) {

        return grade >= MINIMAL_THRESHOLD ? PASSED_MESSAGE : FAILED_MESSAGE;

    }
}