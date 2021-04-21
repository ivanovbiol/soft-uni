import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String PRINT_TEMPLATE = "%.1f -> %d";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        List<Double> numbersList = readIntList();
        Map<Double, Integer> numbersMap = generateNumbersMap(numbersList);
        printNumbersMap(numbersMap);
    }

    private static List<Double> readIntList() {
        return Arrays
                .stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private static Map<Double, Integer> generateNumbersMap(List<Double> numbersList) {
        Map<Double, Integer> numbersMap = new LinkedHashMap<>();

        numbersList
                .forEach(number -> {
                    numbersMap.putIfAbsent(number, 0);
                    int newCount = numbersMap.get(number) + 1;
                    numbersMap.put(number, newCount);
                });

        return numbersMap;
    }

    private static void printNumbersMap(Map<Double, Integer> numbersMap) {
        for (Double currentKey : numbersMap.keySet()) {
            System.out.printf(PRINT_TEMPLATE, currentKey, numbersMap.get(currentKey))
                    .println();
        }
    }
}