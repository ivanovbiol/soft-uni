import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {

    private static final String SPACE_DELIMITER = "\\s+";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Consumer<String> stringConsumer = System.out::println;

        Stream
                .of(new Scanner(System.in).nextLine().split(SPACE_DELIMITER))
                .forEach(stringConsumer);
    }
}
