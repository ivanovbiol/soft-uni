import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String END_COMMAND = "End";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personsList = readPersonsList(scanner);

        printPeopleOrderedByAge(personsList);
    }

    private static List<Person> readPersonsList(Scanner scanner) {
        List<Person> personsList = new ArrayList<>();

        String nextLine = readSingleLineStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            String[] personData = nextLine.split("\\s+");

            String name = personData[0];
            String id = personData[1];
            int age = Integer.parseInt(personData[2]);

            personsList.add(new Person(name, id, age));

            nextLine = readSingleLineStringInput(scanner);
        }

        return personsList;
    }

    private static String readSingleLineStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void printPeopleOrderedByAge(List<Person> personsList) {
        System.out.println(
                personsList
                        .stream()
                        .sorted(Comparator.comparing(Person::getAge))
                        .map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
