import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Engine {

    private static final String DELIMITER = "\\s+";

    public Engine() {
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = readIntNumber(scanner);
        List<Person> personList = new ArrayList<>();

        while (numberOfLines-- > 0) {
            String[] personInfo = readStringArray(scanner);

            String firstName = personInfo[0];
            String lastName = personInfo[1];
            int age = Integer.parseInt(personInfo[2]);

            personList.add(new Person(firstName, lastName, age));

        }

        printPeople(personList);
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split(DELIMITER);
    }

    private void printPeople(List<Person> personList) {
        Comparator<Person> personComparator =
                Comparator.comparing(Person::getFirstName)
                        .thenComparingInt(Person::getAge);

        Consumer<String> personConsumer = System.out::println;

        personList
                .stream()
                .sorted(personComparator)
                .map(Person::toString)
                .forEach(personConsumer);
    }
}