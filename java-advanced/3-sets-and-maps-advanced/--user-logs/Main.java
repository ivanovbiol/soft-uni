import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

    private static final String END_COMMAND = "end";
    private static final String USERNAME_PRINT_TEMPLATE = "%s:";
    private static final String IP_COUNT_PRINT_TEMPLATE = "%s => %d";
    private static final String FINAL_DOT = ".";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> usersAndIpCountMap = new TreeMap<>();
        String nextLine = readStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            String username = nextLine
                    .substring(nextLine.lastIndexOf("=") + 1);
            String ip = nextLine.substring(nextLine.indexOf("=") + 1, nextLine.indexOf(" "));

            usersAndIpCountMap.putIfAbsent(username, new LinkedHashMap<>());
            usersAndIpCountMap.get(username).putIfAbsent(ip, 0);
            int newIpOccurrenceCount = usersAndIpCountMap.get(username).get(ip) + 1;
            usersAndIpCountMap.get(username).put(ip, newIpOccurrenceCount);

            nextLine = readStringInput(scanner);
        }

        usersAndIpCountMap
                .forEach((key, value) -> {
                    System.out.printf(USERNAME_PRINT_TEMPLATE, key).println();

                    System.out.print(
                            value
                                    .entrySet()
                                    .stream()
                                    .map(entry -> String
                                            .format(IP_COUNT_PRINT_TEMPLATE, entry.getKey(),
                                                    entry.getValue()))
                                    .collect(Collectors.joining(", ")));
                    System.out.println(FINAL_DOT);
                });
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }
}