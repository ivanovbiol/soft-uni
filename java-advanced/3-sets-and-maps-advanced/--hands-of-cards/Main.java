import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final String STOP_COMMAND = "JOKER";
    private static final String PRINT_TEMPLATE = "%s: %d";
    private static final char FORBIDDEN_SYMBOL = ':';

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> cardMultiplierMap = fillCardMultiplierMap();
        Map<String, Integer> typeMultiplierMap = fillTypeMultiplierMap();
        Map<String, Set<String>> playersCardsMap = fillPlayersCardsMap(scanner);
        Map<String, Integer> playersResultMap = new LinkedHashMap<>();

        playersCardsMap
                .forEach((key, value) -> {
                    int playerCardsPower = calculateCardsPower(key, playersCardsMap,
                            typeMultiplierMap, cardMultiplierMap);

                    playersResultMap.put(key, playerCardsPower);
                });

        printPlayerAndCards(playersResultMap);
    }

    private static Map<String, Integer> fillCardMultiplierMap() {
        return Map.ofEntries(
                new AbstractMap.SimpleEntry<>("2", 2),
                new AbstractMap.SimpleEntry<>("3", 3),
                new AbstractMap.SimpleEntry<>("4", 4),
                new AbstractMap.SimpleEntry<>("5", 5),
                new AbstractMap.SimpleEntry<>("6", 6),
                new AbstractMap.SimpleEntry<>("7", 7),
                new AbstractMap.SimpleEntry<>("8", 8),
                new AbstractMap.SimpleEntry<>("9", 9),
                new AbstractMap.SimpleEntry<>("10", 10),
                new AbstractMap.SimpleEntry<>("J", 11),
                new AbstractMap.SimpleEntry<>("Q", 12),
                new AbstractMap.SimpleEntry<>("K", 13),
                new AbstractMap.SimpleEntry<>("A", 14));
    }

    private static Map<String, Integer> fillTypeMultiplierMap() {
        return Map.ofEntries(
                new AbstractMap.SimpleEntry<>("S", 4),
                new AbstractMap.SimpleEntry<>("H", 3),
                new AbstractMap.SimpleEntry<>("D", 2),
                new AbstractMap.SimpleEntry<>("C", 1));
    }

    private static Map<String, Set<String>> fillPlayersCardsMap(Scanner scanner) {
        Map<String, Set<String>> playersCardsMap = new LinkedHashMap<>();
        String nextLine = readStringInput(scanner);

        while (!STOP_COMMAND.equals(nextLine)) {
            String playerName = nextLine.substring(0, nextLine.indexOf(FORBIDDEN_SYMBOL));
            String[] cardsArray = nextLine.substring(nextLine.indexOf(FORBIDDEN_SYMBOL) + 2)
                    .split(",\\s+");

            playersCardsMap.putIfAbsent(playerName, new LinkedHashSet<>());

            for (String currentCard : cardsArray) {
                if (isValidCard(currentCard)) {
                    playersCardsMap.get(playerName).add(currentCard);
                }
            }

            nextLine = readStringInput(scanner);
        }

        return playersCardsMap;
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static boolean isValidCard(String currentCard) {
        return currentCard.chars().noneMatch(e -> e == FORBIDDEN_SYMBOL);
    }

    private static int calculateCardsPower(String playerName, Map<String, Set<String>> playersCardsMap,
            Map<String, Integer> typeMultiplierMap, Map<String, Integer> cardMultiplierMap) {
        int power = 0;
        Iterator<String> iterator = playersCardsMap.get(playerName).iterator();

        while (iterator.hasNext()) {
            String currentCard = iterator.next();
            String cardPower = currentCard.substring(0, currentCard.length() - 1);
            String typePower = currentCard.substring(currentCard.length() - 1);

            if (!cardMultiplierMap.containsKey(cardPower) || !typeMultiplierMap.containsKey(
                    typePower)) {
                power += 0;
            }

            power += cardMultiplierMap.get(cardPower) * typeMultiplierMap.get(typePower);
        }

        return power;
    }

    private static void printPlayerAndCards(Map<String, Integer> playersMap) {
        playersMap
                .forEach((key, value) ->
                        System.out.printf(PRINT_TEMPLATE, key, value).println());
    }
}