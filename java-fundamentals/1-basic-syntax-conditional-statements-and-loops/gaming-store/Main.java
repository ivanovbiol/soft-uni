import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<String, Double> GAMES_MAP = new HashMap<>();
    private static final String GAME_TIME = "Game Time";
    private static final String NOT_FOUND = "Not Found";
    private static final String OUT_OF_MONEY = "Out of money!";
    private static final String TOO_EXPENSIVE = "Too Expensive";
    private static final String BOUGHT_GAME_TEMPLATE = "Bought %s";
    private static final String TOTAL_SPEND_AND_REMAINING_TEMPLATE = "Total spent: $%.2f. Remaining: $%.2f";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        addGamesAndPrices();

        double currentBalance = readCurrentBalance(scanner);

       printResult(scanner, currentBalance);

    }

    private static void addGamesAndPrices() {

        GAMES_MAP.putAll(
                Map.of("OutFall 4", 39.99,
                        "CS: OG", 15.99,
                        "Zplinter Zell", 19.99,
                        "Honored 2", 59.99,
                        "RoverWatch", 29.99,
                        "RoverWatch Origins Edition", 39.99

                ));

    }

    private static double readCurrentBalance(Scanner scanner) {

        return Double.parseDouble(scanner.nextLine());

    }

    private static void printResult(Scanner scanner, double currentBalance) {

        double spendMoney = 0.0;

        String nextLine = scanner.nextLine();

        while (!nextLine.equals(GAME_TIME)) {

            if (GAMES_MAP.containsKey(nextLine)) {

                if (GAMES_MAP.get(nextLine) > currentBalance) {

                    System.out.println(TOO_EXPENSIVE);

                } else {

                    System.out.printf(BOUGHT_GAME_TEMPLATE, nextLine).println();
                    currentBalance -= GAMES_MAP.get(nextLine);
                    spendMoney += GAMES_MAP.get(nextLine);

                    if (currentBalance == 0) {
                        System.out.println(OUT_OF_MONEY);
                        return;
                    }

                }

            } else {

                System.out.println(NOT_FOUND);

            }

            nextLine = scanner.nextLine();
        }

        System.out.printf(TOTAL_SPEND_AND_REMAINING_TEMPLATE, spendMoney, currentBalance).println();
    }
}