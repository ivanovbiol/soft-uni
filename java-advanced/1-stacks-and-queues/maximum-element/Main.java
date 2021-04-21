import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static final String DELETE_COMMAND = "2";
    
    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> numberStack = new Stack<>();

        int numberOfLines = readIntNumber(scanner);

        while (numberOfLines-- > 0) {
            String nextLine =readStringInput(scanner);

            if (nextLine.length() != 1) {
                int numberToPush = Integer.parseInt(nextLine.split("\\s+")[1]);
                numberStack.push(numberToPush);
            } else if (nextLine.equals(DELETE_COMMAND) && !numberStack.isEmpty()) {
                numberStack.pop();
            } else {
                System.out.println(getMaxNumberInStack(numberStack));
            }
        }
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static int getMaxNumberInStack(Stack<Integer> numberStack) {
        return numberStack
                .stream()
                .max(Integer::compare)
                .orElse(0);
    }
}
