import java.util.Scanner;

public class Engine {

    private static final String PRINT_TEMPLATE = "Card name: %s of %s; Card power: %d";

    public Engine() {
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        String rankPower = readStringLine(scanner);
        String suitPower = readStringLine(scanner);

        System.out.printf(PRINT_TEMPLATE, rankPower, suitPower,
                SuitPower.valueOf(suitPower).getPower() + RankPowers.valueOf(rankPower).getCardPower())
                .println();
    }

    private String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }
}
