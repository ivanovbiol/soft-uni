import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<String, String> LEGENDARY_ITEMS = new HashMap<>();
    private static final String LEGENDARY_ITEM_OBTAINED_TEMPLATE = "%s obtained!";
    private static final String ITEMS_PRINT_TEMPLATE = "%s: %d";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> collectedKeyItems = new LinkedHashMap<>();
        Map<String, Integer> collectedJunkItems = new LinkedHashMap<>();

        addKeyElements(collectedKeyItems);
        addLegendaryItems();

        String affordedItem = "";
        boolean isObtained = false;

        while (!isObtained) {
            String[] resources = readStringArray(scanner);

            for (int index = 0; index < resources.length; index += 2) {
                int amount = Integer.parseInt(resources[index]);
                String currentResource = resources[index + 1];

                if (collectedKeyItems.containsKey(currentResource)) {
                    int newAmount = collectedKeyItems.get(currentResource) + amount;
                    collectedKeyItems.put(currentResource, newAmount);

                    if (itemCanBeAfforded(collectedKeyItems, currentResource)) {
                        isObtained = true;
                        affordedItem = currentResource;
                        newAmount = collectedKeyItems.get(affordedItem) - 250;
                        collectedKeyItems.put(affordedItem, newAmount);
                        break;
                    }

                } else {
                    collectedJunkItems.putIfAbsent(currentResource, 0);
                    int newAmount = collectedJunkItems.get(currentResource) + amount;
                    collectedJunkItems.put(currentResource, newAmount);
                }

            }
        }

        System.out.printf(LEGENDARY_ITEM_OBTAINED_TEMPLATE, LEGENDARY_ITEMS.get(affordedItem))
                .println();

        collectedKeyItems
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int result = e2.getValue().compareTo(e1.getValue());
                    if (result == 0) {
                        result = e1.getKey().compareTo(e2.getKey());
                    }
                    return result;
                })
                .forEach(e ->
                        System.out.printf(
                                ITEMS_PRINT_TEMPLATE, e.getKey(), e.getValue())
                                .println());

        collectedJunkItems
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e ->
                        System.out.printf(
                                ITEMS_PRINT_TEMPLATE, e.getKey(), e.getValue())
                                .println());
    }

    private static void addKeyElements(Map<String, Integer> collectedKeyItems) {
        collectedKeyItems.put("shards", 0);
        collectedKeyItems.put("fragments", 0);
        collectedKeyItems.put("motes", 0);
    }

    private static void addLegendaryItems() {
        LEGENDARY_ITEMS.put("shards", "Shadowmourne");
        LEGENDARY_ITEMS.put("fragments", "Valanyr");
        LEGENDARY_ITEMS.put("motes", "Dragonwrath");
    }

    private static boolean itemCanBeAfforded(Map<String, Integer> collectedKeyItems,
            String currentResource) {
        return collectedKeyItems.get(currentResource) >= 250;
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().toLowerCase().split("\\s+");
    }
}
