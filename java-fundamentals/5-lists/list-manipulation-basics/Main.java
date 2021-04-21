import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String END_COMMAND = "end";
    private static final String ADD_COMMAND = "Add";
    private static final String REMOVE_COMMAND = "Remove";
    private static final String REMOVE_AT_COMMAND = "RemoveAt";
    private static final String INSERT_COMMAND = "Insert";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> intList = readIntList(scanner);

        System.out.println(processCommandsAndGetResult(intList, scanner));

    }

    private static List<Integer> readIntList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static String processCommandsAndGetResult(List<Integer> intList, Scanner scanner) {
        String nextLine = readStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            int number = 0;
            int index = 0;
            String command = nextLine.substring(0, nextLine.indexOf(" "));

            switch (command) {
                case ADD_COMMAND:
                    number = Integer.parseInt(nextLine.split("\\s+")[1]);
                    addNumberToList(intList, number);
                    break;
                case REMOVE_COMMAND:
                    number = Integer.parseInt(nextLine.split("\\s+")[1]);
                    removeNumberFromList(intList, number);
                    break;
                case REMOVE_AT_COMMAND:
                    index = Integer.parseInt(nextLine.split("\\s+")[1]);
                    removeNumberAtIndex(intList, index);
                    break;
                case INSERT_COMMAND:
                    number = Integer.parseInt(nextLine.split("\\s+")[1]);
                    index = Integer.parseInt(nextLine.split("\\s+")[2]);
                    insertNumberAtIndex(intList, number, index);
                    break;
            }
            nextLine = readStringInput(scanner);
        }

        return intList
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static void addNumberToList(List<Integer> intList, int number) {
        intList.add(number);
    }

    private static void removeNumberFromList(List<Integer> intList, int number) {
        intList.remove(Integer.valueOf(number));
    }

    private static void removeNumberAtIndex(List<Integer> intList, int index) {
        intList.remove(index);
    }

    private static void insertNumberAtIndex(List<Integer> intList, int number, int index) {
        intList.add(index, number);
    }
}