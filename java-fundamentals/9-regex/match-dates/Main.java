import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String REGEX_STRING = "\\b(?<day>\\d{2})([-.\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";
    private static final String PRINT_TEMPLATE = "Day: %s, Month: %s, Year: %s";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {

        String input = readStringInput();

        Pattern pattern = Pattern.compile(REGEX_STRING);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String day = matcher.group("day");
            String month = matcher.group("month");
            String year = matcher.group("year");

            System.out.printf(PRINT_TEMPLATE, day, month, year).println();
        }

    }

    private static String readStringInput() {
        return new Scanner(System.in).nextLine();
    }
}
