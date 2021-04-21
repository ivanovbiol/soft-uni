import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Map<String, List<String>> synonymsMap = readMap();

        printResult(synonymsMap);
    }

    private static Map<String, List<String>> readMap() {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> synonymsMap = new LinkedHashMap<>();

        int number = Integer.parseInt(scanner.nextLine());

        while (number-- > 0) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            synonymsMap.putIfAbsent(word, new LinkedList<>());
            synonymsMap.get(word).add(synonym);
        }

        return synonymsMap;
    }

    private static void printResult(Map<String, List<String>> synonymsMap) {
        synonymsMap
                .entrySet()
                .forEach(e -> {
                    System.out.printf("%s - %s", e.getKey(),
                            e.getValue()
                                    .stream()
                                    .map(String::valueOf)
                                    .collect(Collectors.joining(", ")))
                            .println();
                });
    }
}
