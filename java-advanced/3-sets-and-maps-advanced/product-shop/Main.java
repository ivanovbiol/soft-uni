import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    private static final String END_COMMAND = "Revision";
    private static final String SHOP_PRINT_TEMPLATE = "%s->";
    private static final String PRODUCT_AND_PRICE_PRINT_TEMPLATE = "Product: %s, Price: %.1f";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopAndProductsMap = generateMap(scanner);
        printShopMap(shopAndProductsMap);
    }

    private static Map<String, Map<String, Double>> generateMap(Scanner scanner) {
        Map<String, Map<String, Double>> shopAndProductsMap = new TreeMap<>();

        String nextLine = readStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            String[] shopAndProductsInfo = nextLine.split(",\\s+");
            String shopName = shopAndProductsInfo[0];
            String productName = shopAndProductsInfo[1];
            double productPrice = Double.parseDouble(shopAndProductsInfo[2]);

            shopAndProductsMap.putIfAbsent(shopName, new LinkedHashMap<>());
            shopAndProductsMap.get(shopName).put(productName, productPrice);

            nextLine = readStringInput(scanner);
        }

        return shopAndProductsMap;
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void printShopMap(Map<String, Map<String, Double>> shopAndProductsMap) {
        shopAndProductsMap
                .forEach((key, value) -> {
                    System.out.printf(SHOP_PRINT_TEMPLATE, key).println();

                    value
                            .forEach((subKey, subValue) -> {
                                System.out.printf(
                                        PRODUCT_AND_PRICE_PRINT_TEMPLATE, subKey, subValue)
                                        .println();
                            });
                });
    }
}