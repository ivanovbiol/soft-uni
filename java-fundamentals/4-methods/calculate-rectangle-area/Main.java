import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double width = readDoubleNumber(scanner);
        double length = readDoubleNumber(scanner);

        System.out.printf("%.0f", getResult(width, length));

    }

    private static double readDoubleNumber(Scanner scanner) {

        return Double.parseDouble(scanner.nextLine());

    }

    private static double getResult(double width, double length) {

        return width * length;

    }
}