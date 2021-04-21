import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static final String TRUE_MESSAGE = "true";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        List<Integer> commandsList = readIntList(scanner);
        List<Integer> numbersList = readIntList(scanner);

        System.out.println(getResult(commandsList, numbersList));
    }

    private static List<Integer> readIntList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String getResult(List<Integer> commandsList, List<Integer> numbersList) {
        Queue<Integer> numbersQueue = new ArrayDeque<>();

        int offerNumbers = commandsList.remove(0);
        int pollNumbers = commandsList.remove(0);
        int queryNumber = commandsList.remove(0);

        while (offerNumbers-- > 0 && !numbersList.isEmpty()) {
            numbersQueue.offer(numbersList.remove(0));
        }

        while (pollNumbers-- > 0 && !numbersQueue.isEmpty()) {
            numbersQueue.poll();
        }

        return numbersQueue.contains(queryNumber) ?
                TRUE_MESSAGE :
                String.valueOf(numbersQueue
                        .stream()
                        .min(Integer::compare)
                        .orElse(0));
    }
}
