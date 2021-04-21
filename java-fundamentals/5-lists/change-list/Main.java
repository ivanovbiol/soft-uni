import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String END = "end";
    private static final String DELETE = "Delete";
    private static final String INSERT = "Insert";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = readIntList(scanner);

        processCommandsAndPrintResult(scanner, integerList);
    }

    private static List<Integer> readIntList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String readNextLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void processCommandsAndPrintResult(Scanner scanner, List<Integer> integerList) {
        String nextLine = readNextLine(scanner);

        while (!END.equals(nextLine)) {
            String command = nextLine.split("\\s+")[0];
            int element = Integer.parseInt(nextLine.split("\\s+")[1]);

            switch (command) {
                case DELETE:

                    deleteElements(integerList, element);

                    break;
                case INSERT:

                    int position = Integer.parseInt(nextLine.split("\\s+")[2]);

                    insertElementAtGivenPosition(integerList, element, position);

                    break;
            }
            nextLine = readNextLine(scanner);

        }

        System.out.println(
                integerList
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")));
    }

    private static void deleteElements(List<Integer> integerList, int element) {
        integerList.removeIf(e -> e == element);
    }

    private static void insertElementAtGivenPosition(List<Integer> integerList, int element,
            int position) {
        integerList.add(position, element);
    }
}