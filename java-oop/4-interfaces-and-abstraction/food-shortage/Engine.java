import java.util.*;

public class Engine {

    private static final String STOP_COMMAND = "End";
    private static final String SPLIT_DELIMITER = "\\s+";

    private Map<String, Buyer> buyerMap;

    public Engine() {
        this.setBuyerMap(new LinkedHashMap<>());
    }

    // Getter
    private Map<String, Buyer> getBuyerMap() {
        return this.buyerMap;
    }

    // Setter
    private void setBuyerMap(Map<String, Buyer> buyerMap) {
        this.buyerMap = buyerMap;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = readIntNumber(scanner);

        while (numberOfLines-- > 0) {
            String[] unitInfo = readStringArray(scanner);

            String name = unitInfo[0];
            int age = Integer.parseInt(unitInfo[1]);
            String group = "";
            String id = "";
            String birthDate = "";

            if (unitInfo.length == 3) {
                group = unitInfo[2];

                addBuyerToMap(name, new Rebel(name, age, group));
            } else {
                id = unitInfo[2];
                birthDate = unitInfo[3];

                addBuyerToMap(name, new Citizen(name, age, id, birthDate));
            }
        }

        String queryBuyerName = readStringLine(scanner);

        while (!STOP_COMMAND.equals(queryBuyerName)) {
            queryBuyerBuysFood(queryBuyerName);

            queryBuyerName = readStringLine(scanner);
        }

        System.out.println(getTotalBoughtFood());
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split(SPLIT_DELIMITER);
    }

    private void addBuyerToMap(String name, Buyer buyer) {
        this.getBuyerMap().put(name, buyer);
    }

    private String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private void queryBuyerBuysFood(String queryBuyerName) {
        if (this.getBuyerMap().containsKey(queryBuyerName)) {
            this.getBuyerMap().get(queryBuyerName).buyFood();
        }
    }

    private int getTotalBoughtFood() {
        return this.getBuyerMap()
                .values()
                .stream()
                .mapToInt(Buyer::getFood)
                .sum();
    }
}
