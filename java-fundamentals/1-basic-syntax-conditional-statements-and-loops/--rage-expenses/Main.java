import java.util.Scanner;

public class Main {

    private static final String RAGE_EXPENSES_TEMPLATE = "Rage expenses: %.2f lv.";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = readIntegerInput(scanner);
        double singleHeadsetPrice = readDoubleInput(scanner);
        double singleMousePrice = readDoubleInput(scanner);
        double singleKeyboardPrice = readDoubleInput(scanner);
        double singleDisplayPrice = readDoubleInput(scanner);

        System.out.println(
                getResult(lostGamesCount, singleHeadsetPrice, singleMousePrice, singleKeyboardPrice,
                        singleDisplayPrice));

    }

    private static int readIntegerInput(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static double readDoubleInput(Scanner scanner) {

        return Double.parseDouble(scanner.nextLine());

    }

    private static String getResult(int lostGamesCount, double singleHeadsetPrice,
            double singleMousePrice, double singleKeyboardPrice, double singleDisplayPrice) {

        int brokenHeadsets = lostGamesCount / 2;
        int brokenMice = lostGamesCount / 3;
        int brokenKeyboards = lostGamesCount / 6;
        int brokenDisplays = brokenKeyboards / 2;

        double rageExpenses =
                (brokenHeadsets * singleHeadsetPrice) + (brokenMice * singleMousePrice) + (
                        brokenKeyboards * singleKeyboardPrice) + (brokenDisplays
                        * singleDisplayPrice);

        return String.format(RAGE_EXPENSES_TEMPLATE, rageExpenses);

    }
}