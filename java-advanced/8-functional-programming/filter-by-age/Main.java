import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    private static final String DELIMITER = ",\\s+";
    private static final String YOUNGER_CONDITION = "younger";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int number = readIntNumber(scanner);
        Person[] people = readPersonArray(scanner, number);

        String condition = readStringLine(scanner);
        int ageCondition = readIntNumber(scanner);
        String printFormat = readStringLine(scanner);

        Predicate<Person> filterPeopleByAgeBasedOnTheCondition =
                person -> condition.equals(YOUNGER_CONDITION) ?
                        person.getAge() <= ageCondition :
                        person.getAge() >= ageCondition;

        Consumer<Person> printPersonConsumer = person -> System.out
                .println(person.printPersonData(printFormat));

        printPeople(people, filterPeopleByAgeBasedOnTheCondition, printPersonConsumer);
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static Person[] readPersonArray(Scanner scanner, int number) {
        Person[] tempArray = new Person[number];

        for (int index = 0; index < number; index++) {
            String[] personData = scanner.nextLine().split(DELIMITER);

            tempArray[index] = new Person(personData[0], Integer.parseInt(personData[1]));
        }

        return tempArray;
    }

    private static String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void printPeople(Person[] people,
            Predicate<Person> filterPeopleByAgeBasedOnTheCondition,
            Consumer<Person> printPersonConsumer) {
        Arrays
                .stream(people)
                .filter(filterPeopleByAgeBasedOnTheCondition)
                .forEach(printPersonConsumer);
    }
}
