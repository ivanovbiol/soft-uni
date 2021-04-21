import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double number = readDoubleNumber(scanner);
        int power = readIntNumber(scanner);

        System.out.println(getResult(number, power));

    }

    private static double readDoubleNumber(Scanner scanner) {

        return Double.parseDouble(scanner.nextLine());

    }

    private static int readIntNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static String getResult(double number, int power) {

        DecimalFormat decimalFormat = new DecimalFormat("0.####");

        return decimalFormat.format(Math.pow(number, power));

    }
}