import java.util.*;
import java.util.function.*;

public class Engine {

    private static final String STOP_COMMAND = "End";
    private static final String SPLIT_DELIMITER = "\\s+";

    private static final String CITIZEN_TYPE = "Citizen";
    private static final String PET_TYPE = "Pet";
    private static final String ROBOT_TYPE = "Robot";

    private List<Birthable> birthableList;

    public Engine() {
        this.setBirthableList(new LinkedList<>());
    }

    // Getter
    private List<Birthable> getBirthableList() {
        return this.birthableList;
    }

    // Setter
    private void setBirthableList(List<Birthable> birthableList) {
        this.birthableList = birthableList;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        String nextLine = readStringLine(scanner);

        while (!STOP_COMMAND.equals(nextLine)) {
            String[] unitInfo = nextLine.split(SPLIT_DELIMITER);
            String unitType = unitInfo[0];

            String name = unitInfo[1];
            int age = 0;
            String birthDate = "";
            String id = "";

            switch (unitType) {
                case CITIZEN_TYPE:
                    age = Integer.parseInt(unitInfo[2]);
                    id = unitInfo[3];
                    birthDate = unitInfo[4];

                    addBirthableUnitToList(new Citizen(name, age, id, birthDate));
                    break;
                case PET_TYPE:
                    birthDate = unitInfo[2];

                    addBirthableUnitToList(new Pet(name, birthDate));
                    break;
                case ROBOT_TYPE:
                    id = unitInfo[2];

                    // It is useless to store the robot object in a collection, because we do NOT
                    // need them in the task
                    Identifiable robot = new Robot(name, id);
                    break;
            }

            nextLine = readStringLine(scanner);
        }

        String queryBirthDateYear = readStringLine(scanner);

        printAllUnitsWithQueryBirthDateYear(queryBirthDateYear);
    }

    private String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private void addBirthableUnitToList(Birthable birthableUnit) {
        this.getBirthableList().add(birthableUnit);
    }

    private void printAllUnitsWithQueryBirthDateYear(String queryBirthDateYear) {
        Predicate<String> predicate = birthDate -> birthDate.endsWith(queryBirthDateYear);

        Consumer<String> consumer = System.out::println;

        this.getBirthableList()
                .stream()
                .map(Birthable::getBirthDate)
                .filter(predicate)
                .forEach(consumer);
    }
}
