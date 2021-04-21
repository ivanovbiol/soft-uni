import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static final String FIRST_PLAYER_WON = "First player win!";
    private static final String SECOND_PLAYER_WON = "Second player win!";
    private static final String DRAW_MESSAGE = "Draw!";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayersCards = readIntSet(scanner);
        Set<Integer> secondPlayersCards = readIntSet(scanner);

        int counter = 50;

        while (counter-- > 0) {
            int firstPlayerNumber = firstPlayersCards.iterator().next();
            int secondPlayerNumber = secondPlayersCards.iterator().next();
            firstPlayersCards.remove(firstPlayerNumber);
            secondPlayersCards.remove(secondPlayerNumber);

            if (firstPlayerNumber > secondPlayerNumber) {
                firstPlayersCards.add(firstPlayerNumber);
                firstPlayersCards.add(secondPlayerNumber);

                if (secondPlayersCards.isEmpty()) {
                    break;
                }
            } else if (secondPlayerNumber > firstPlayerNumber) {
                secondPlayersCards.add(secondPlayerNumber);
                secondPlayersCards.add(firstPlayerNumber);

                if (firstPlayersCards.isEmpty()) {
                    break;
                }
            }
        }

        System.out.println(
                firstPlayersCards.size() > secondPlayersCards.size() ? FIRST_PLAYER_WON :
                        secondPlayersCards.size() > firstPlayersCards.size() ? SECOND_PLAYER_WON
                                : DRAW_MESSAGE);
    }

    private static Set<Integer> readIntSet(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}