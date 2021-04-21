import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    private static final String OUTPUT_TEMPLATE = "%d centuries = %d years = %s days = %s hours = %s minutes";
    private static final double DAYS_IN_ONE_YEAR = 365.2422;

    public static void main(String[] args) {

        int century = Integer.parseInt(new Scanner(System.in).nextLine());

        long years = century * 100L;
        BigDecimal days = new BigDecimal(years * DAYS_IN_ONE_YEAR);
        BigDecimal hours = days.multiply(new BigDecimal(24));
        BigDecimal minutes = hours.multiply(new BigDecimal(60));

        System.out.printf(OUTPUT_TEMPLATE,
                century,
                years,
                days.setScale(0, RoundingMode.HALF_UP),
                hours.setScale(0, RoundingMode.HALF_UP),
                minutes.setScale(0, RoundingMode.HALF_UP));

    }
}