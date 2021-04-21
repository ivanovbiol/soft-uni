import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Main {

    private static final String DELIMITER = ",\\s+";
    private static final String PRICES_WITH_VAT_MESSAGE = "Prices with VAT:";
    private static final String PRINT_DOUBLE_NUMBER_TEMPLATE = "%.2f";
    private static final double VAT_MULTIPLIER = 1.2;

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        double[] numbers = readDoubleArray();

        System.out.println(PRICES_WITH_VAT_MESSAGE);

        UnaryOperator<Double> addVatToNumber = number -> number * VAT_MULTIPLIER;

        for (double number : numbers) {
            System.out.printf(PRINT_DOUBLE_NUMBER_TEMPLATE, addVatToNumber.apply(number)).println();
        }
    }

    private static double[] readDoubleArray() {
        return Arrays
                .stream(new Scanner(System.in).nextLine().split(DELIMITER))
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
