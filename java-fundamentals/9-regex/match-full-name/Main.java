import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String REGEX_STRING = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {

        String input = readStringInput();

        Pattern pattern = Pattern.compile(REGEX_STRING);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }

    private static String readStringInput() {
        return new Scanner(System.in).nextLine();
    }
}
