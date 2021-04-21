import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String ADD_OPERATION = "add";
    private static final String MULTIPLY_OPERATION = "multiply";
    private static final String SUBTRACT_OPERATION = "subtract";
    private static final String DIVIDE_OPERATION = "divide";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String product = readStringInput(scanner);
        int quantity = readIntNumber(scanner);

        Map<String, Double> productsSinglePrice = addProductsAndSinglePrices();

        processAndPrintResult(product, quantity, productsSinglePrice);

    }

    private static String readStringInput(Scanner scanner) {

        return scanner.nextLine();

    }

    private static int readIntNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static Map<String, Double> addProductsAndSinglePrices() {

        Map<String, Double> productsSinglePrice = new HashMap<>();
        productsSinglePrice.put("coffee", 1.5);
        productsSinglePrice.put("water", 1.00);
        productsSinglePrice.put("coke", 1.40);
        productsSinglePrice.put("snacks", 2.00);

        return productsSinglePrice;

    }

    private static void processAndPrintResult(String product, int quantity,
            Map<String, Double> productsSinglePrice) {

        System.out.printf("%.2f", productsSinglePrice.get(product) * quantity);

    }
}