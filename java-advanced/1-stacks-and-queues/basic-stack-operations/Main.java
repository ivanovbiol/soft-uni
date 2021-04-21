import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    public static final String TRUE_MESSAGE = "true";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberCommands = readIntList(scanner);
        List<Integer> numbersList = readNumbersAsList(scanner);

        System.out.println(getResult(numbersList, numberCommands));
    }

    private static List<Integer> readIntList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<Integer> readNumbersAsList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    private static String getResult(List<Integer> numbersList, List<Integer> numberCommands) {
        Stack<Integer> numberStack = new Stack<>();

        int pushNumbers = numberCommands.get(0);
        int popNumbers = numberCommands.get(1);
        int queryNumber = numberCommands.get(2);

        while (pushNumbers-- > 0 && numbersList.size() != 0) {
            numberStack.push(numbersList.remove(0));
        }

        while (popNumbers-- > 0 && numberStack.size() != 0) {
            numberStack.pop();
        }

        return numberStack.contains(queryNumber) ?
                TRUE_MESSAGE :
                String.valueOf(numberStack
                        .stream()
                        .min(Integer::compare)
                        .orElse(0));
    }
}
