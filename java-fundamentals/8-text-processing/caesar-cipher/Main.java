import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        System.out.println(
                new Scanner(System.in)
                        .nextLine()
                        .chars()
                        .map(e -> e = e + 3)
                        .mapToObj(Character::toChars)
                        .map(String::new)
                        .collect(Collectors.joining()));
    }
}
