import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    private static final String SPACE_DELIMITER = " ";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int number = readIntNumber(scanner);

        Predicate<String> predicate = word -> word.length() <= number;

        Stream
                .of(scanner.nextLine().split(SPACE_DELIMITER))
                .filter(predicate)
                .forEach(System.out::println);
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}