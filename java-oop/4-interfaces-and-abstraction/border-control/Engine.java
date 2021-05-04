import java.util.*;
import java.util.function.*;

public class Engine {

    private static final String STOP_COMMAND = "End";
    private static final String SPLIT_DELIMITER = "\\s+";

    private List<Identifiable> passingUnits;

    public Engine() {
        this.setPassingUnits(new LinkedList<>());
    }

    // Getter
    private List<Identifiable> getPassingUnits() {
        return this.passingUnits;
    }

    // Setter
    private void setPassingUnits(List<Identifiable> passingUnits) {
        this.passingUnits = passingUnits;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        String nextLine = readStringLine(scanner);

        while (!STOP_COMMAND.equals(nextLine)) {
            String[] unitInfo = nextLine.split(SPLIT_DELIMITER);

            String name = unitInfo[0];
            int age = unitInfo.length == 3 ? Integer.parseInt(unitInfo[1]) : 0;
            String id = unitInfo[unitInfo.length - 1];

            if (age != 0) {
                addUnit(new Citizen(name, age, id));
            } else {
                addUnit(new Robot(name, id));
            }

            nextLine = readStringLine(scanner);
        }

        String bannedIds = readStringLine(scanner);

        printAllBannedUnits(bannedIds);
    }

    private String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private void addUnit(Identifiable unit) {
        this.getPassingUnits().add(unit);
    }

    private void printAllBannedUnits(String bannedIds) {
        Predicate<String> predicate =
                id -> id.endsWith(bannedIds);

        Consumer<String> consumer = System.out::println;

        this.getPassingUnits()
                .stream()
                .map(Identifiable::getId)
                .filter(predicate)
                .forEach(consumer);
    }
}
