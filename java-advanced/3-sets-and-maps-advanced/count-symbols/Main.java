import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    private static final String PRINT_TEMPLATE = "%s: %d time/s";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        String input = readString();
        Map<Character, Integer> charOccurrencesMap = generateMap(input);
        printMap(charOccurrencesMap);
    }

    private static String readString() {
        return new Scanner(System.in).nextLine();
    }

    private static Map<Character, Integer> generateMap(String input) {
        Map<Character, Integer> charOccurrencesMap = new TreeMap<>();

        for (int index = 0; index < input.length(); index++) {
            char currentChar = input.charAt(index);

            charOccurrencesMap.putIfAbsent(currentChar, 0);
            int numberOfOccurrences = charOccurrencesMap.get(currentChar) + 1;
            charOccurrencesMap.put(currentChar, numberOfOccurrences);
        }

        return charOccurrencesMap;
    }

    private static void printMap(Map<Character, Integer> charOccurrencesMap) {
        charOccurrencesMap
                .forEach((key, value) ->
                        System.out.printf(PRINT_TEMPLATE, key, value).println());
    }
}