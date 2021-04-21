import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String END = "End";
    private static final String INVALID_INDEX_MESSAGE = "Invalid index";
    private static final String ADD_COMMAND = "Add";
    private static final String INSERT_COMMAND = "Insert";
    private static final String REMOVE_COMMAND = "Remove";
    private static final String SHIFT_COMMAND = "Shift";
    private static final String LEFT = "left";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = readIntList(scanner);

        processCommandsAndPrintResult(scanner, integerList);
    }

    private static List<Integer> readIntList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String readNextLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void processCommandsAndPrintResult(Scanner scanner, List<Integer> integerList) {
        String nextLine = readNextLine(scanner);

        while (!END.equals(nextLine)) {
            String command = nextLine.substring(0, nextLine.indexOf(" "));
            int number = 0;
            int index = 0;

            switch (command) {
                case ADD_COMMAND:

                    number = Integer.parseInt(nextLine.split("\\s+")[1]);
                    addNumber(integerList, number);

                    break;
                case INSERT_COMMAND:

                    number = Integer.parseInt(nextLine.split("\\s+")[1]);
                    index = Integer.parseInt(nextLine.split("\\s+")[2]);
                    insertNumberAtIndex(integerList, number, index);

                    break;
                case REMOVE_COMMAND:

                    index = Integer.parseInt(nextLine.split("\\s+")[1]);
                    removeElementAtIndex(integerList, index);

                    break;
                case SHIFT_COMMAND:

                    index = Integer.parseInt(nextLine.split("\\s+")[2]);

                    if (nextLine.contains(LEFT)) {
                        shiftLeft(integerList, index);
                    } else {
                        shiftRight(integerList, index);
                    }

                    break;
            }

            nextLine = readNextLine(scanner);
        }

        System.out.println(
                integerList
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))
        );
    }

    private static void addNumber(List<Integer> integerList, int number) {
        integerList.add(number);
    }

    private static void insertNumberAtIndex(List<Integer> integerList, int number, int index) {
        if (isNotValidIndex(integerList, index)) {
            System.out.println(INVALID_INDEX_MESSAGE);
            return;
        }
        integerList.add(index, number);
    }

    private static void removeElementAtIndex(List<Integer> integerList, int index) {
        if (isNotValidIndex(integerList, index)) {
            System.out.println(INVALID_INDEX_MESSAGE);
            return;
        }
        integerList.remove(index);
    }

    private static void shiftLeft(List<Integer> integerList, int count) {
        for (int i = 0; i < count; i++) {
            integerList.add(integerList.get(0));
            integerList.remove(0);
        }
    }

    private static void shiftRight(List<Integer> integerList, int count) {
        for (int i = 0; i < count; i++) {
            integerList.add(0, integerList.get(integerList.size() - 1));
            integerList.remove(integerList.size() - 1);
        }
    }

    private static boolean isNotValidIndex(List<Integer> integerList, int index) {
        return index < 0 || index >= integerList.size();
    }
}