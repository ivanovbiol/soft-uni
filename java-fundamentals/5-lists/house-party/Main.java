import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String NAME_ALREADY_IN_THE_LIST_TEMPLATE = "%s is already in the list!";
    private static final String NAME_IS_NOT_IN_THE_LIST_TEMPLATE = "%s is not in the list!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = readIntNumber(scanner);

        processCommandsAndPrintResult(scanner, numberOfLines);
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String readNextLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void processCommandsAndPrintResult(Scanner scanner, int numberOfLines) {
        List<String> namesList = new ArrayList<>();

        while (numberOfLines-- > 0) {
            String nextLine = readNextLine(scanner);

            String personName = nextLine.split("\\s+")[0];

            if (nextLine.split("\\s+").length == 3) {
                addPerson(namesList, personName);
            } else {
                removePerson(namesList, personName);
            }
        }

        System.out.println(
                namesList
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator()))
        );
    }

    private static void addPerson(List<String> namesList, String personName) {
        if (namesList.contains(personName)) {
            System.out.printf(NAME_ALREADY_IN_THE_LIST_TEMPLATE, personName).println();
        } else {
            namesList.add(personName);
        }
    }

    private static void removePerson(List<String> namesList, String personName) {
        if (!namesList.contains(personName)) {
            System.out.printf(NAME_IS_NOT_IN_THE_LIST_TEMPLATE, personName).println();
        } else {
            namesList.remove(personName);
        }
    }
}