import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String REGEX_STRING = "%(?<name>[A-Z][a-z]+)%[^|$%.]*" +
            "<(?<product>\\w+)>[^|$%.]*\\|(?<quantity>\\d+)\\|[^|$%.]*?" +
            "(?<price>\\d+\\.?\\d*)\\$";
    private static final String STOP_COMMAND = "end of shift";
    private static final String ORDER_PRINT_TEMPLATE = "%s: %s - %.2f";
    private static final String TOTAL_INCOME_PRINT_TEMPLATE = "Total income: %.2f";
    private static final String NAME_GROUP_TEMPLATE = "name";
    private static final String PRODUCT_GROUP_TEMPLATE = "product";
    private static final String QUANTITY_GROUP_TEMPLATE = "quantity";
    private static final String PRICE_GROUP_TEMPLATE = "price";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile(REGEX_STRING);
        String input = readStringInput(scanner);

        double totalIncome = 0.0;

        while (!STOP_COMMAND.equals(input)) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                double currentSum = Double.parseDouble(matcher.group(QUANTITY_GROUP_TEMPLATE)) *
                        Double.parseDouble(matcher.group(PRICE_GROUP_TEMPLATE));

                System.out.printf(
                        ORDER_PRINT_TEMPLATE,
                        matcher.group(NAME_GROUP_TEMPLATE),
                        matcher.group(PRODUCT_GROUP_TEMPLATE),
                        currentSum).println();

                totalIncome += currentSum;
            }

            input = readStringInput(scanner);
        }

        System.out.printf(TOTAL_INCOME_PRINT_TEMPLATE, totalIncome).println();
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
