import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String REGEX_STRING = "^>>(?<furnitureType>[A-Za-z]+)<<(?<singlePrice>[0-9]+|[0-9]+.[0-9]+)!(?<quantity>[0-9]+)$";
    private static final String STOP_COMMAND = "Purchase";
    private static final String BOUGHT_FURNITURE_PRINT_TEMPLATE = "Bought furniture:";
    private static final String TOTAL_PRICE_PRINT_TEMPLATE = "Total money spend: %.2f";
    private static final String FURNITURE_TYPE_GROUP_NAME = "furnitureType";
    private static final String SINGLE_PRICE_GROUP_NAME = "singlePrice";
    private static final String QUANTITY_GROUP_NAME = "quantity";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        List<String> boughtFurniture = new LinkedList<>();
        double totalPrice = 0.0;

        Pattern pattern = Pattern.compile(REGEX_STRING);

        String input = readStringInput(scanner);

        while (!STOP_COMMAND.equals(input)) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                totalPrice += addFurnitureAndReturnPrice(boughtFurniture, matcher);
            }

            input = readStringInput(scanner);
        }

        printResult(boughtFurniture, totalPrice);
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static double addFurnitureAndReturnPrice(List<String> boughtFurniture,
            Matcher matcher) {
        String furnitureType = matcher.group(FURNITURE_TYPE_GROUP_NAME);
        double singlePrice = Double.parseDouble(matcher.group(SINGLE_PRICE_GROUP_NAME));
        int quantity = Integer.parseInt(matcher.group(QUANTITY_GROUP_NAME));

        boughtFurniture.add(furnitureType);

        return singlePrice * quantity;
    }

    private static void printResult(List<String> boughtFurniture, double totalPrice) {
        System.out.println(BOUGHT_FURNITURE_PRINT_TEMPLATE);

        boughtFurniture
                .forEach(System.out::println);

        System.out.printf(TOTAL_PRICE_PRINT_TEMPLATE, totalPrice)
                .println();
    }
}
