import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // When we have several lines of input we need to add the Scanner as parameter
        // otherwise each method won't read the new lines of input
        String name = readName(scanner);
        int age = readAge(scanner);
        double grade = readGrade(scanner);

        System.out.println(gerResult(name, age, grade));

    }

    private static String readName(Scanner scanner) {

        return scanner.nextLine();

    }

    private static int readAge(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static double readGrade(Scanner scanner) {

        return Double.parseDouble(scanner.nextLine());

    }

    private static String gerResult(String name, int age, double grade) {

        return String.format("Name: %s, Age: %d, Grade: %.2f", name, age, grade);

    }
}