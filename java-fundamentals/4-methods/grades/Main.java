import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double grade = readDoubleNumber();

        printResult(grade);
        
    }

    private static double readDoubleNumber() {

        return Double.parseDouble(new Scanner(System.in).nextLine());

    }

    private static void printResult(double grade) {

        String forPrint = "";

        if (grade >= 2 && grade < 3) {
            forPrint = "Fail";
        } else if (grade < 3.5) {
            forPrint = "Poor";
        } else if (grade < 4.5) {
            forPrint = "Good";
        } else if (grade < 5.5) {
            forPrint = "Very good";
        } else {
            forPrint = "Excellent";
        }

        System.out.println(forPrint);

    }
}