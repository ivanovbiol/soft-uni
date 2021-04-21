import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String START = "Start";
    private static final String END = "End";
    private static final String INVALID_MONEY_FORMAT = "Cannot accept %.2f";
    private static final String INVALID_PRODUCT = "Invalid product";
    private static final String NOT_ENOUGH_MONEY = "Sorry, not enough money";
    private static final String SUCCESSFUL_PURCHASE = "Purchased %s";
    private static final String CHANGE_FORMAT = "Change: %.2f";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> validCoinsList = addValidCoinsFormat();

        Map<String, Double> validProductAndPricesMap = addValidProductsAndPrices();

        double totalInsertedCoins = collectAllInsertedCoins(scanner, validCoinsList);

        purchaseProducts(scanner, validProductAndPricesMap, totalInsertedCoins);

    }

    private static List<String> addValidCoinsFormat() {

        return new ArrayList<>(List.of("0.1", "0.2", "0.5", "1", "2"));
    }

    private static Map<String, Double> addValidProductsAndPrices() {

        return new HashMap<>(Map.of(
                "Nuts", 2.0,
                "Water", 0.7,
                "Crisps", 1.5,
                "Soda", 0.8,
                "Coke", 1.0));

    }

    private static double collectAllInsertedCoins(Scanner scanner, List<String> validCoinsList) {

        double totalInsertedCoins = 0.0;

        String coins = readNextLine(scanner);

        while (!coins.equals(START)) {

            if (!validCoinsList.contains(coins)) {
                System.out
                        .printf(INVALID_MONEY_FORMAT, Double.parseDouble(coins)).println();
            } else {
                totalInsertedCoins += Double.parseDouble(coins);
            }

            coins = readNextLine(scanner);

        }

        return totalInsertedCoins;

    }

    private static void purchaseProducts(Scanner scanner, Map<String, Double> validProductAndPricesMap,
            double totalInsertedCoins) {

        String product = readNextLine(scanner);

        while (!product.equals(END)) {

            if (!validProductAndPricesMap.containsKey(product)) {
                System.out.println(INVALID_PRODUCT);
            } else {

                if (validProductAndPricesMap.get(product) > totalInsertedCoins) {
                    System.out.println(NOT_ENOUGH_MONEY);
                } else {
                    totalInsertedCoins -= validProductAndPricesMap.get(product);
                    System.out.printf(SUCCESSFUL_PURCHASE, product).println();
                }
            }

            product = readNextLine(scanner);

        }

        System.out.printf(CHANGE_FORMAT, totalInsertedCoins);

    }

    private static String readNextLine(Scanner scanner) {

        return scanner.nextLine();

    }
}