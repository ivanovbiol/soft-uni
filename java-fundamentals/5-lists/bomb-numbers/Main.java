import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = readIntList(scanner);

        processInputAndPrintResult(scanner, integerList);
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

    private static void processInputAndPrintResult(Scanner scanner, List<Integer> integerList) {
        String nextLine = readNextLine(scanner);

        int specialNumber = Integer.parseInt(nextLine.split("\\s+")[0]);
        int bombPower = Integer.parseInt(nextLine.split("\\s+")[1]);

        // It is not the best practice to change the value of i in the loop, but works good in this case
        for (int i = 0; i < integerList.size(); i++) {

            if (integerList.get(i) == specialNumber) {
                removeElements(integerList, bombPower, i);
                i = 0;
            }

        }

        System.out.println(
                integerList
                        .stream()
                        .mapToInt(Integer::valueOf)
                        .sum());
    }

    private static void removeElements(List<Integer> integerList, int bombPower, int index) {
        int removeStartIndex = 0;

        if (index - bombPower >= 0) {
            removeStartIndex = index - bombPower;
        }

        int removeEndIndex = Math.min(index + bombPower + 1, integerList.size());

        integerList.subList(removeStartIndex, removeEndIndex).clear();
    }
}