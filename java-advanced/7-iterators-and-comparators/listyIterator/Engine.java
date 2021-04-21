package list_task;

import static list_task.StaticVariables.*;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Engine {

    public Engine() {
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = getData(scanner);
        ListyIterator listyIterator = new ListyIterator(elements);

        String command = readCommand(scanner);

        while (!END_COMMAND.equals(command)) {
            switch (command) {
                case MOVE_COMMAND:
                    System.out.println(listyIterator.move());
                    break;
                case PRINT_COMMAND:
                    try {
                        listyIterator.print();
                    } catch (InvalidParameterException invalidParameterException) {
                        System.out.println(invalidParameterException.getMessage());
                    }
                    break;
                case HAS_NEXT_COMMAND:
                    System.out.println(listyIterator.hasNext());
                    break;
            }

            command = readCommand(scanner);
        }

    }

    private static String readCommand(Scanner scanner) {
        return scanner.nextLine().split("\\s+")[0];
    }

    private List<String> getData(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+")).skip(1)
                .collect(Collectors.toList());
    }

}
