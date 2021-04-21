import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String END_COMMAND = "end";
    private static final String CONTAINS_COMMAND = "Contains";
    private static final String PRINT_COMMAND = "Print";
    private static final String EVEN_COMMAND = "even";
    private static final String GET_COMMAND = "Get";
    private static final String FILTER_COMMAND = "Filter";
    private static final String CONDITION_SMALLER_THAN = "<";
    private static final String CONDITION_BIGGER_THAN = ">";
    private static final String CONDITION_SMALLER_OR_EQUAL_THAN = "<=";
    private static final String CONDITION_BIGGER_OR_EQUAL_THAN = ">=";
    private static final String YES_MESSAGE = "Yes";
    private static final String NO_SUCH_ELEMENT_MESSAGE = "No such number";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> intList = readIntList(scanner);

        processCommands(intList, scanner);

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

    private static void processCommands(List<Integer> intList, Scanner scanner) {
        String nextLine = readStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            int number = 0;
            String condition = "";

            String command = nextLine.substring(0, nextLine.indexOf(" "));

            switch (command) {
                case CONTAINS_COMMAND:
                    number = Integer.parseInt(nextLine.split("\\s+")[1]);
                    System.out.println(containsNumber(intList, number));
                    break;
                case PRINT_COMMAND:
                    condition = nextLine.substring(nextLine.indexOf(" ") + 1);
                    System.out.println(printNumbersFromList(intList, condition));
                    break;
                case GET_COMMAND:
                    System.out.println(getSum(intList));
                    break;
                case FILTER_COMMAND:
                    condition = nextLine.split("\\s+")[1];
                    number = Integer.parseInt(nextLine.split("\\s+")[2]);
                    System.out.println(filterNumbers(intList, condition, number));
                    break;
            }
            nextLine = readStringInput(scanner);
        }
    }

    private static String containsNumber(List<Integer> intList, int number) {
        return intList.contains(number) ? YES_MESSAGE : NO_SUCH_ELEMENT_MESSAGE;
    }

    private static String printNumbersFromList(List<Integer> intList, String condition) {
        if (condition.equals(EVEN_COMMAND)) {
            return intList
                    .stream()
                    .filter(e -> e % 2 == 0)
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
        }
        return intList
                .stream()
                .filter(e -> e % 2 != 0)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static int getSum(List<Integer> intList) {
        return intList
                .stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private static String filterNumbers(List<Integer> intList, String condition, int number) {
        String result = "";

        switch (condition) {
            case CONDITION_BIGGER_OR_EQUAL_THAN:
                result = intList
                        .stream()
                        .filter(e -> e >= number)
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "));
                break;
            case CONDITION_BIGGER_THAN:
                result = intList
                        .stream()
                        .filter(e -> e > number)
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "));
                break;
            case CONDITION_SMALLER_OR_EQUAL_THAN:
                result = intList
                        .stream()
                        .filter(e -> e <= number)
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "));
                break;
            case CONDITION_SMALLER_THAN:
                result = intList
                        .stream()
                        .filter(e -> e < number)
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "));
                break;
        }
        return result;
    }
}