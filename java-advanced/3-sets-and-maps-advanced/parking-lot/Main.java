import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final String END_COMMAND = "END";
    private static final String IN_COMMAND = "IN";
    private static final String OUT_COMMAND = "OUT";
    private static final String EMPTY_PARKING = "Parking Lot is Empty";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingSet = new LinkedHashSet<>();
        String nextLine = readStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            String command = nextLine.split(",\\s+")[0];
            String car = nextLine.split(",\\s+")[1];

            switch (command) {
                case IN_COMMAND:
                    parkingSet.add(car);
                    break;
                case OUT_COMMAND:
                    parkingSet.remove(car);
                    break;
            }

            nextLine = readStringInput(scanner);
        }

        printParking(parkingSet);
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void printParking(Set<String> parkingSet) {
        if (parkingSet.isEmpty()) {
            System.out.println(EMPTY_PARKING);
        } else {
            parkingSet
                    .forEach(System.out::println);
        }
    }
}