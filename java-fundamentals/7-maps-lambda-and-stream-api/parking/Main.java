import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String ALREADY_REGISTERED_PLATE_TEMPLATE = "ERROR: already registered with plate number %s";
    private static final String USER_REGISTERED_PLATE_TEMPLATE = "%s registered %s successfully";
    private static final String USERNAME_NOT_FOUND_TEMPLATE = "ERROR: user %s not found";
    private static final String USERNAME_UNREGISTERED_TEMPLATE = "%s unregistered successfully";
    private static final String REGISTER_COMMAND = "register";
    private static final String UNREGISTER_COMMAND = "unregister";
    private static final String PRINT_TEMPLATE = "%s => %s";


    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int number = readIntNumber(scanner);

        Map<String, String> parkingMap = new LinkedHashMap<>();

        while (number-- > 0) {
            String[] input = readStringArray(scanner);

            processCommand(input, parkingMap);
        }

        parkingMap
                .forEach((key, value) ->
                        System.out.printf(PRINT_TEMPLATE, key, value)
                                .println());
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static void processCommand(String[] input, Map<String, String> parkingMap) {
        String command = input[0];
        String userName = input[1];

        switch (command) {
            case REGISTER_COMMAND:
                String registerPlate = input[2];

                if (parkingMap.containsKey(userName)) {
                    System.out.printf(
                            ALREADY_REGISTERED_PLATE_TEMPLATE, registerPlate)
                            .println();
                    return;
                }

                parkingMap.put(userName, registerPlate);
                System.out.printf(
                        USER_REGISTERED_PLATE_TEMPLATE, userName, registerPlate)
                        .println();
                break;
            case UNREGISTER_COMMAND:
                if (!parkingMap.containsKey(userName)) {
                    System.out.printf(
                            USERNAME_NOT_FOUND_TEMPLATE, userName)
                            .println();
                    return;
                }

                parkingMap.remove(userName);
                System.out.printf(
                        USERNAME_UNREGISTERED_TEMPLATE, userName)
                        .println();
                break;
        }
    }
}
