import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final String ODD_CONDITION = "odd";
    private static final String SPACE_SIGN = " ";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int startRange = scanner.nextInt();
        int endRange = scanner.nextInt();
        scanner.nextLine();
        String condition = scanner.nextLine();

        IntPredicate filterCondition = number -> condition.equals(ODD_CONDITION) ?
                number % 2 == 1 : number % 2 == 0;

        IntFunction<String> intToStringFunction = String::valueOf;

        System.out.println(
                IntStream
                        .rangeClosed(startRange, endRange)
                        .filter(filterCondition)
                        .mapToObj(intToStringFunction)
                        .collect(Collectors.joining(SPACE_SIGN)));
    }
}
