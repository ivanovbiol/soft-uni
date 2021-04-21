import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String REGEX_STRING = "\\+359([- ])2\\1[\\d]{3}\\1[\\d]{4}\\b";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {

        String input = readStringInput();

        List<String> listOfPhones = new LinkedList<>();

        Pattern pattern = Pattern.compile(REGEX_STRING);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            listOfPhones.add(matcher.group());
        }

        System.out.println(String.join(", ", listOfPhones));
    }

    private static String readStringInput() {
        return new Scanner(System.in).nextLine();
    }
}
