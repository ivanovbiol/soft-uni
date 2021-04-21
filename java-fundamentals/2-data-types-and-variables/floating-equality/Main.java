import java.util.Scanner;

public class Main {

    private static final String TRUE_MESSAGE = "True";
    private static final String FALSE_MESSAGE = "False";
    private static final double PRECISION_EPS = 0.000001;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double firstDouble = readDouble(scanner);
        double secondDouble = readDouble(scanner);

        System.out.println(areEqualDoubleNumbers(firstDouble, secondDouble));

    }

    private static double readDouble(Scanner scanner) {

        return Double.parseDouble(scanner.nextLine());

    }

    private static String areEqualDoubleNumbers(double firstDouble, double secondDouble) {

        return Math.abs(firstDouble - secondDouble) < PRECISION_EPS ?
                TRUE_MESSAGE : FALSE_MESSAGE;

    }

}