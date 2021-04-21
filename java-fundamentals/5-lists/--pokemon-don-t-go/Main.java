import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

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

    private static int readInputNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void processCommandsAndPrintResult(Scanner scanner, List<Integer> integerList) {
        List<Integer> removedValues = new ArrayList<>();

        while (integerList.size() != 0) {
            int index = readInputNumber(scanner);
            removeValueFromList(integerList, removedValues, index);
        }

        System.out.println(
                removedValues
                        .stream()
                        .mapToInt(Integer::intValue)
                        .sum());
    }

    private static void removeValueFromList(List<Integer> integerList, List<Integer> removedValues,
            int index) {
        int value = 0;

        if (index < 0) {

            value = integerList.remove(0);
            integerList.add(0, integerList.get(integerList.size() - 1));
            removedValues.add(value);

            increaseAndDecreaseElements(integerList, value);

        } else if (index >= integerList.size()) {

            value = integerList.remove(integerList.size() - 1);
            integerList.add(integerList.get(0));
            removedValues.add(value);

            increaseAndDecreaseElements(integerList, value);

        } else {

            value = integerList.remove(index);
            removedValues.add(value);

            increaseAndDecreaseElements(integerList, value);
        }
    }

    private static void increaseAndDecreaseElements(List<Integer> integerList, int value) {
        for (int i = 0; i < integerList.size(); i++) {

            if (integerList.get(i) <= value) {
                integerList.set(i, integerList.get(i) + value);
            } else {
                integerList.set(i, integerList.get(i) - value);
            }

        }
    }
}