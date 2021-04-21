import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static final String END_COMMAND = "print";
    private static final String CANCEL_COMMAND = "cancel";
    private static final String CANCELED_PRINT_TEMPLATE = "Canceled %s";
    private static final String EMPTY_QUEUE_MESSAGE = "Printer is on standby";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        String nextLine = readStringInput(scanner);
        Queue<String> printQueue = new ArrayDeque<>();

        while (!END_COMMAND.equals(nextLine)) {
            if (!nextLine.equals(CANCEL_COMMAND)) {
                printQueue.offer(nextLine);
            } else {
                if (!printQueue.isEmpty()) {
                    System.out.printf(CANCELED_PRINT_TEMPLATE, printQueue.poll()).println();
                } else {
                    System.out.println(EMPTY_QUEUE_MESSAGE);
                }
            }

            nextLine = readStringInput(scanner);
        }

        printQueue.forEach(System.out::println);
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
