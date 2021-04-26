import java.util.Arrays;
import java.util.function.Consumer;

public class Engine {

    private static final String CARD_RANKS_MESSAGE = "Card Ranks:";
    private static final String PRINT_TEMPLATE = "Ordinal value: %d; Name value: %s";

    public Engine() {
    }

    public void run() {
        System.out.println(CARD_RANKS_MESSAGE);

        Consumer<CardRanks> cardSuitConsumer = element -> System.out.printf(
                PRINT_TEMPLATE, element.ordinal(), element.name()).println();

        Arrays
                .stream(CardRanks.values())
                .forEach(cardSuitConsumer);
    }

}
