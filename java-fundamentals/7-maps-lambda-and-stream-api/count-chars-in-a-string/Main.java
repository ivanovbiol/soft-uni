import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String PRINT_TEMPLATE = "%s -> %d";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        String inputString = readStringInput();

        Map<Character, Integer> charsMap = new LinkedHashMap<>();

        for (int index = 0; index < inputString.length(); index++) {
            char currentCharacter = inputString.charAt(index);
            if (currentCharacter == ' ') {
                continue;
            }
            charsMap.putIfAbsent(currentCharacter, 0);

            int count = charsMap.get(inputString.charAt(index));
            charsMap.put(currentCharacter, ++count);
        }

        charsMap
                .forEach((key, value) -> System.out.printf(PRINT_TEMPLATE, key, value)
                        .println());
    }

    private static String readStringInput() {
        return new Scanner(System.in).nextLine();
    }
}
