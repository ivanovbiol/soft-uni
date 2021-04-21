import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println(readInputAndGetResult());
    }

    private static String readInputAndGetResult() {
        return Stream
                .of(new Scanner(System.in).nextLine().split("\\s+"))
                .filter(e -> e.length() % 2 == 0)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
