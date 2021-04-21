import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String MONEY_ARE_ENOUGH_TEMPLATE = "The money is enough - it would cost %.2flv.";
    private static final String MONEY_ARE_NOT_ENOUGH_TEMPLATE = "Ivan Cho will need %.2flv more.";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double moneyAmount = readDoubleInput(scanner);
        int studentCount = readIntegerInput(scanner);
        double singleLightsaberPrice = readDoubleInput(scanner);
        double singleRobePrice = readDoubleInput(scanner);
        double singleBeltPrice = readDoubleInput(scanner);

        System.out.println(
                getResult(moneyAmount, studentCount, singleLightsaberPrice, singleRobePrice,
                        singleBeltPrice));

    }

    private static double readDoubleInput(Scanner scanner) {

        return Double.parseDouble(scanner.nextLine());

    }

    private static int readIntegerInput(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static String getResult(double moneyAmount, int studentCount,
            double singleLightsaberPrice, double singleRobePrice, double singleBeltPrice) {

        int neededMoreLightsabers = (int) Math.ceil(studentCount * 0.1);
        int discountForNumberOfNeededBelts = studentCount / 6;

        double moneyNeeded =
                (singleLightsaberPrice * (studentCount + neededMoreLightsabers) + (singleRobePrice * studentCount)
                        + (singleBeltPrice * (studentCount - discountForNumberOfNeededBelts)));

        return moneyAmount >= moneyNeeded ? String.format(MONEY_ARE_ENOUGH_TEMPLATE, moneyNeeded) :
                String.format(MONEY_ARE_NOT_ENOUGH_TEMPLATE, moneyNeeded - moneyAmount);

    }
}