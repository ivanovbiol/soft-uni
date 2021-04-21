import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    private static final String SPACE_DELIMITER = "\\s+";
    private static final String APPEND_STRING = "Sir ";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Consumer<String[]> stringConsumer =
                arr -> Arrays.stream(arr)
                        .forEach(current -> System.out.println(APPEND_STRING + current));

        stringConsumer.accept(new Scanner(System.in).nextLine().split(SPACE_DELIMITER));
    }
}