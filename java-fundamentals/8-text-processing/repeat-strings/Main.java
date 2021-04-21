import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        String[] input = readStringArray(scanner);

        StringBuilder stringBuilder = new StringBuilder();

        Arrays
                .stream(input)
                .forEach(e ->
                        stringBuilder
                                .append(e.repeat(e.length())));

        System.out.println(stringBuilder.toString());
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
