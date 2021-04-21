import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {

    private static final String SPACE_DELIMITER = "\\s+";
    private static final String APPEND_STRING = "Sir ";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Consumer<String> stringConsumer =
                element -> System.out.println(APPEND_STRING + element);

        Stream
                .of(new Scanner(System.in).nextLine().split(SPACE_DELIMITER))
                .forEach(stringConsumer);
    }
}
