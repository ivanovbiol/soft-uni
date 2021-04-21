import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Engine {

    private static final String END_COMMAND = "End";
    private static final String COMPANY_COMMAND = "company";
    private static final String POKEMON_COMMAND = "pokemon";
    private static final String PARENT_COMMAND = "parents";
    private static final String CHILDREN_COMMAND = "children";
    private static final String CAR_COMMAND = "car";

    private Map<String, Person> personMap;

    public Engine() {
        this.setPersonMap(new LinkedHashMap<>());
    }

    // Getter
    private Map<String, Person> getPersonMap() {
        return this.personMap;
    }

    // Setter
    private void setPersonMap(Map<String, Person> personMap) {
        this.personMap = personMap;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = readStringArray(scanner);

        while (!END_COMMAND.equals(inputLine[0])) {
            String personName = inputLine[0];
            String command = inputLine[1];

            switch (command) {
                case COMPANY_COMMAND:
                    addCompany(inputLine, personName);
                    break;
                case POKEMON_COMMAND:
                    addPokemon(inputLine, personName);
                    break;
                case PARENT_COMMAND:
                    addParent(inputLine, personName);
                    break;
                case CHILDREN_COMMAND:
                    addChild(inputLine, personName);
                    break;
                case CAR_COMMAND:
                    addCar(inputLine, personName);
                    break;
            }

            inputLine = readStringArray(scanner);
        }

        String queryPerson = readStringLine(scanner);

        System.out.println(this.getPersonMap().get(queryPerson).toString());
    }

    private String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private void addCompany(String[] inputLine, String personName) {
        String companyName = inputLine[2];
        String department = inputLine[3];
        double salary = Double.parseDouble(inputLine[4]);

        addPersonToMapIfNotPresent(personName);

        Company company = new Company(companyName, department, salary);
        this.getPersonMap().get(personName).addCompany(company);
    }

    private void addPersonToMapIfNotPresent(String personName) {
        if (!this.getPersonMap().containsKey(personName)) {
            Person person = new Person(personName);
            this.getPersonMap().put(personName, person);
        }
    }

    private void addPokemon(String[] inputLine, String personName) {
        String pokemonName = inputLine[2];
        String pokemonType = inputLine[3];

        addPersonToMapIfNotPresent(personName);

        Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
        this.getPersonMap().get(personName).addPokemon(pokemon);
    }

    private void addParent(String[] inputLine, String personName) {
        String parentName = inputLine[2];
        String parentBirthday = inputLine[3];

        addPersonToMapIfNotPresent(personName);

        Parents parent = new Parents(parentName, parentBirthday);
        this.getPersonMap().get(personName).addParent(parent);
    }

    private void addChild(String[] inputLine, String personName) {
        String childName = inputLine[2];
        String childBirthday = inputLine[3];

        addPersonToMapIfNotPresent(personName);

        Children child = new Children(childName, childBirthday);
        this.getPersonMap().get(personName).addChild(child);
    }

    private void addCar(String[] inputLine, String personName) {
        String carModel = inputLine[2];
        int carSpeed = Integer.parseInt(inputLine[3]);

        addPersonToMapIfNotPresent(personName);

        Car car = new Car(carModel, carSpeed);
        this.getPersonMap().get(personName).addCar(car);
    }

    private static String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }
}
