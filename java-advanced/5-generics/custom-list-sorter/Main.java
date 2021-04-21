import java.util.Scanner;

public class Main {

    private static final String END_COMMAND = "End";
    private static final String ADD_COMMAND = "Add";
    private static final String REMOVE_COMMAND = "Remove";
    private static final String CONTAINS_COMMAND = "Contains";
    private static final String SWAP_COMMAND = "Swap";
    private static final String GREATER_COMMAND = "Greater";
    private static final String MAX_COMMAND = "Max";
    private static final String MIN_COMMAND = "Min";
    private static final String SORT_COMMAND = "Sort";
    private static final String PRINT_COMMAND = "Print";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> customList = new CustomList<>();

        String nextLine = readStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            String command = nextLine.split("\\s+")[0];
            String element;
            int index;

            switch (command) {
                case ADD_COMMAND:
                    element = nextLine.split("\\s+")[1];
                    customList.add(element);
                    break;
                case REMOVE_COMMAND:
                    index = Integer.parseInt(nextLine.split("\\s+")[1]);
                    customList.remove(index);
                    break;
                case CONTAINS_COMMAND:
                    element = nextLine.split("\\s+")[1];
                    System.out.println(customList.contains(element));
                    break;
                case SWAP_COMMAND:
                    int firstIndex = Integer.parseInt(nextLine.split("\\s+")[1]);
                    int secondIndex = Integer.parseInt(nextLine.split("\\s+")[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case GREATER_COMMAND:
                    element = nextLine.split("\\s+")[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                case MAX_COMMAND:
                    System.out.println(customList.getMax());
                    break;
                case MIN_COMMAND:
                    System.out.println(customList.getMin());
                    break;
                case SORT_COMMAND:
                    Sorter.sort(customList);
                    break;
                case PRINT_COMMAND:
                    System.out.println(customList.print());
                    break;
            }

            nextLine = readStringInput(scanner);
        }
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }
}