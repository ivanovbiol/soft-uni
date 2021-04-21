import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String OUTPUT_MESSAGE_TEMPLATE = "%s player wins! Sum: %d";
    private static final String FIRST_MESSAGE = "First";
    private static final String SECOND_MESSAGE = "Second";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayersCards = readIntList(scanner);
        List<Integer> secondPlayersCards = readIntList(scanner);

        processInputAndPrintResult(firstPlayersCards, secondPlayersCards);
    }

    private static List<Integer> readIntList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void processInputAndPrintResult(List<Integer> firstPlayersCards, List<Integer> secondPlayersCards) {

        while (firstPlayersCards.size() != 0 && secondPlayersCards.size() != 0) {

            if (firstPlayersCards.get(0).equals(secondPlayersCards.get(0))) {
                removeBothCards(firstPlayersCards, secondPlayersCards);
            } else if (firstPlayersCards.get(0) > secondPlayersCards.get(0)) {
                firstPlayerTakesTheCards(firstPlayersCards, secondPlayersCards);
            } else {
                secondPlayerTakesTheCards(firstPlayersCards, secondPlayersCards);
            }

        }

        if (firstPlayersCards.size() == 0) {
            printWinner(secondPlayersCards, SECOND_MESSAGE);
        } else {
            printWinner(firstPlayersCards, FIRST_MESSAGE);
        }

    }

    private static void removeBothCards(List<Integer> firstPlayersCards, List<Integer> secondPlayersCards) {
        firstPlayersCards.remove(0);
        secondPlayersCards.remove(0);
    }

    private static void firstPlayerTakesTheCards(List<Integer> firstPlayersCards, List<Integer> secondPlayersCards) {
        firstPlayersCards.add(firstPlayersCards.remove(0));
        firstPlayersCards.add(secondPlayersCards.remove(0));
    }

    private static void secondPlayerTakesTheCards(List<Integer> firstPlayersCards, List<Integer> secondPlayersCards) {
        secondPlayersCards.add(secondPlayersCards.remove(0));
        secondPlayersCards.add(firstPlayersCards.remove(0));
    }


    private static void printWinner(List<Integer> winnersCards, String player) {
        System.out.printf(OUTPUT_MESSAGE_TEMPLATE, player,
                winnersCards
                        .stream()
                        .mapToInt(Integer::valueOf)
                        .sum());
    }
}
