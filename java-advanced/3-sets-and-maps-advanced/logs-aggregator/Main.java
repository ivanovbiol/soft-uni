import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    private static final String PRINT_TEMPLATE = "%s: %d [%s]";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> userTotalLogTimeMap = new TreeMap<>();
        Map<String, TreeSet<String>> userIPsMap = new TreeMap<>();

        int numberOfLines = readIntNumber(scanner);

        while (numberOfLines-- > 0) {
            String input = readStringInput(scanner);
            String ip = input.substring(0, input.indexOf(" "));
            String username = input.substring(input.indexOf(" ") + 1, input.lastIndexOf(" "));
            int loggedTime = Integer.parseInt(input.substring(input.lastIndexOf(" ") + 1));

            userTotalLogTimeMap.putIfAbsent(username, 0);
            int newLoggedTime = userTotalLogTimeMap.get(username) + loggedTime;
            userTotalLogTimeMap.put(username, newLoggedTime);

            userIPsMap.putIfAbsent(username, new TreeSet<>());
            userIPsMap.get(username).add(ip);
        }

        printResult(userTotalLogTimeMap, userIPsMap);
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void printResult(Map<String, Integer> userTotalLogTimeMap,
            Map<String, TreeSet<String>> userIPsMap) {

        userTotalLogTimeMap
                .forEach((key, value) -> {
                    String userIPs =
                            String.join(", ", userIPsMap.get(key));

                    System.out.printf(PRINT_TEMPLATE, key, value, userIPs).println();
                });
    }
}