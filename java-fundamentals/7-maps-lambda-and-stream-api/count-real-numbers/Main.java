import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<Double, Integer> numbersMap = readMap();

        getResult(numbersMap);
    }

    private static Map<Double, Integer> readMap() {
        Map<Double, Integer> numbersMap = new HashMap<>();

        double[] inputArray = Arrays
                .stream(new Scanner(System.in).nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Arrays.stream(inputArray)
                .forEach(element -> {
                    if (!numbersMap.containsKey(element)) {
                        numbersMap.put(element, 0);
                    }
                    numbersMap.put(element, numbersMap.get(element) + 1);
                });

        return numbersMap;
    }

    private static void getResult(Map<Double, Integer> numbersMap) {
        DecimalFormat decimalFormat = new DecimalFormat("#.####");

        numbersMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e ->
                        System.out.println(
                                decimalFormat.format(e.getKey()) +
                                        " -> " + e.getValue()));
    }
}
