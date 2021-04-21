import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Engine {

    private static final int SORTING_AGE_CRITERIA = 30;

    private List<Person> personList;

    public Engine() {
        this.setPersonList(new ArrayList<>());
    }

    // Getter
    private List<Person> getPersonList() {
        return this.personList;
    }

    // Setter
    private void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = readIntNumber(scanner);

        while (numberOfLines-- > 0) {
            String[] personData = readStringArray(scanner);

            String personName = personData[0];
            int personAge = Integer.parseInt(personData[1]);

            this.getPersonList().add(new Person(personName, personAge));
        }

        printPeople();
    }

    private int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private void printPeople() {
        this.getPersonList()
                .stream()
                .filter(e -> e.getAge() > SORTING_AGE_CRITERIA)
                .sorted(Comparator.comparing(Person::getName))
                .map(Person::toString)
                .forEach(System.out::println);
    }
}
