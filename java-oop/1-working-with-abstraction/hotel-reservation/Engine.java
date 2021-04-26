import java.util.Scanner;

public class Engine {

    private static final String DELIMITER = "\\s+";

    public Engine() {
    }

    public void run() {
        String[] vacationInfo = readStringArray();

        double pricePerDay = Double.parseDouble(vacationInfo[0]);
        int numberOfDays = Integer.parseInt(vacationInfo[1]);
        Season season = Season.valueOf(vacationInfo[2].toUpperCase());
        DiscountType discountType = DiscountType.valueOf(vacationInfo[3].toUpperCase());

        PriceCalculator priceCalculator =
                new PriceCalculator(pricePerDay, numberOfDays, season, discountType);

        System.out.println(priceCalculator.calculateTotalPrice());
    }

    private static String[] readStringArray() {
        return new Scanner(System.in).nextLine().split(DELIMITER);
    }
}
