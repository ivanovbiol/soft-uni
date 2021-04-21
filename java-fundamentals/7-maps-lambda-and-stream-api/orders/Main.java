import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String BUY_COMMAND = "buy";
    private static final String PRODUCT_PRINT_TEMPLATE = "%s -> %.2f";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> productPrices = new LinkedHashMap<>();
        Map<String, Double> productQuantities = new LinkedHashMap<>();

        String nextLine = readStringInput(scanner);

        while (!BUY_COMMAND.equals(nextLine)) {
            String[] input = nextLine.split("\\s+");

            addProductPriceAndQuantity(productPrices, productQuantities, input);

            nextLine = readStringInput(scanner);
        }

        printProductsAndPrices(productPrices, productQuantities);
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void addProductPriceAndQuantity(Map<String, Double> productPrices,
            Map<String, Double> productQuantities, String[] input) {
        String product = input[0];
        double price = Double.parseDouble(input[1]);
        double quantity = Double.parseDouble(input[2]);

        productPrices.putIfAbsent(product, 0.0);
        productPrices.put(product, price);

        productQuantities.putIfAbsent(product, 0.0);
        double newQuantity = productQuantities.get(product) + quantity;
        productQuantities.put(product, newQuantity);
    }

    private static void printProductsAndPrices(Map<String, Double> productPrices,
            Map<String, Double> productQuantities) {
        productPrices
                .forEach((key, value) ->
                        System.out.printf(PRODUCT_PRINT_TEMPLATE,
                                key, value * productQuantities.get(key)).println());
    }
}
