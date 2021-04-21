import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String END_COMMAND = "Lumpawaroo";
    private static final String FORCE_USER_JOINS_FORCE_SIDE_TEMPLATE = "%s joins the %s side!";
    private static final String SIDE_AND_MEMBERS_COUNT_PRINT_TEMPLATE = "Side: %s, Members: %d";
    private static final String FORCE_USER_PRINT_TEMPLATE = "! %s";
    private static final String DASH_TEMPLATE = "|";
    private static final String DASH_REGEX_TEMPLATE = "\\s*\\|\\s*";
    private static final String ARROW_REGEX_TEMPLATE = "\\s*->\\s*";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> forceSideForceUserMap = new HashMap<>();

        String input = readStringInput(scanner);
        String forceSide = "";
        String forceUser = "";

        while (!END_COMMAND.equals(input)) {
            if (input.contains(DASH_TEMPLATE)) {
                forceSide = input.split(DASH_REGEX_TEMPLATE)[0];
                forceUser = input.split(DASH_REGEX_TEMPLATE)[1];

                addForceUserInForceSide(forceSideForceUserMap, forceSide, forceUser);
            } else {
                forceUser = input.split(ARROW_REGEX_TEMPLATE)[0];
                forceSide = input.split(ARROW_REGEX_TEMPLATE)[1];

                if (userIsPresent(forceSideForceUserMap, forceUser, forceSide)) {
                    removeForceUserFromForceSide(forceSideForceUserMap, forceUser, forceSide);
                    addForceUserInForceSide(forceSideForceUserMap, forceSide, forceUser);
                }
                addForceUserInForceSide(forceSideForceUserMap, forceSide, forceUser);

                System.out.printf(
                        FORCE_USER_JOINS_FORCE_SIDE_TEMPLATE, forceUser, forceSide)
                        .println();
            }

            input = readStringInput(scanner);
        }

        printResult(forceSideForceUserMap);
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static boolean userIsPresent(Map<String, List<String>> forceSideForceUserMap,
            String forceUser, String forceSide) {
        return forceSideForceUserMap
                .values()
                .stream()
                .anyMatch(e -> e.contains(forceUser));
    }

    private static void removeForceUserFromForceSide(
            Map<String, List<String>> forceSideForceUserMap, String forceUser, String forceSide) {
        forceSideForceUserMap
                .entrySet()
                .stream()
                .filter(key -> !key.getKey().equals(forceSide))
                .forEach(e -> e.getValue().remove(forceUser));
    }

    private static void addForceUserInForceSide(Map<String, List<String>> forceSideForceUserMap,
            String forceSide, String forceUser) {
        forceSideForceUserMap.putIfAbsent(forceSide, new ArrayList<>());

        if (!forceSideForceUserMap.get(forceSide).contains(forceUser)) {
            forceSideForceUserMap.get(forceSide).add(forceUser);
        }
    }

    private static void printResult(Map<String, List<String>> forceSideForceUserMap) {
        forceSideForceUserMap
                .entrySet()
                .stream()
                .sorted((firstElement, secondElement) -> {

                    int result = Integer.compare(
                            secondElement.getValue().size(),
                            firstElement.getValue().size());

                    if (result == 0) {
                        result = firstElement.getKey().compareTo(secondElement.getKey());
                    }
                    return result;
                })
                .forEach((element) -> {
                    if (element.getValue().size() != 0) {
                        System.out.printf(
                                SIDE_AND_MEMBERS_COUNT_PRINT_TEMPLATE, element.getKey(),
                                element.getValue().size())
                                .println();

                        element
                                .getValue()
                                .stream()
                                .sorted()
                                .forEach(user ->
                                        System.out.printf(
                                                FORCE_USER_PRINT_TEMPLATE, user)
                                                .println());
                    }
                });
    }
}
