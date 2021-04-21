import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String NAME_REGEX_STRING = "(?<name>[A-Z]+|[a-z]+)";
    private static final String DISTANCE_REGEX_STRING = "(?<distance>\\d)";
    private static final String STOP_COMMAND = "end of race";
    private static final String FINAL_PRINT_TEMPLATE = "1st place: %s\n2nd place: %s\n3rd place: %s";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> participantsMap = readParticipants(scanner);
        String nextLine = readStringInput(scanner);

        Pattern namePattern = Pattern.compile(NAME_REGEX_STRING);
        Pattern distancePattern = Pattern.compile(DISTANCE_REGEX_STRING);

        while (!STOP_COMMAND.equals(nextLine)) {
            Matcher nameMatcher = namePattern.matcher(nextLine);
            Matcher distanceMatcher = distancePattern.matcher(nextLine);

            String participantName = findParticipantNameFromMatcher(nameMatcher);

            if (participantsMap.containsKey(participantName)) {
                int newDistance = participantsMap.get(participantName) + findDistanceFromMatcher(
                        distanceMatcher);

                participantsMap.put(participantName, newDistance);
            }

            nextLine = readStringInput(scanner);
        }

        printResult(participantsMap);
    }

    private static Map<String, Integer> readParticipants(Scanner scanner) {
        Map<String, Integer> participantsMap = new HashMap<>();

        Arrays
                .stream(scanner.nextLine().split(",\\s+"))
                .forEach(e -> participantsMap.putIfAbsent(e, 0));

        return participantsMap;
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static String findParticipantNameFromMatcher(Matcher nameMatcher) {
        StringBuilder stringBuilder = new StringBuilder();

        while (nameMatcher.find()) {
            stringBuilder.append(nameMatcher.group());
        }

        return stringBuilder.toString();
    }

    private static int findDistanceFromMatcher(Matcher distanceMatcher) {
        int totalDistance = 0;

        while (distanceMatcher.find()) {
            totalDistance += Integer.parseInt(distanceMatcher.group());
        }

        return totalDistance;
    }

    private static void printResult(Map<String, Integer> participantsMap) {
        List<String> names = new LinkedList<>();

        participantsMap
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int result = e2.getValue().compareTo(e1.getValue());
                    if (result == 0) {
                        result = e1.getKey().compareTo(e2.getKey());
                    }
                    return result;
                })
                .map(Entry::getKey)
                .limit(3)
                .forEach(names::add);

        System.out.printf(
                FINAL_PRINT_TEMPLATE,
                names.remove(0),
                names.remove(0),
                names.remove(0)).println();
    }
}
