import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> wordsMap = readMap();

        printResult(wordsMap);
    }

    private static Map<String, Integer> readMap() {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> wordsMap = new LinkedHashMap<>();

        String[] nextLineArray = readInputArrays(scanner);

        for (String current : nextLineArray) {
            wordsMap.putIfAbsent(current, 0);
            wordsMap.put(current, wordsMap.get(current) + 1);
        }

        return wordsMap;
    }

    private static String[] readInputArrays(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(String::toLowerCase)
                .toArray(String[]::new);
    }

    private static void printResult(Map<String, Integer> wordsMap) {
        System.out.println(
                wordsMap
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() % 2 != 0)
                        .map(Entry::getKey)
                        .collect(Collectors.joining(", ")));
    }
}
