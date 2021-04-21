import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstNumbersList = readIntList(scanner);
        List<Integer> secondNumbersList = readIntList(scanner);

        System.out.println(getResult(firstNumbersList, secondNumbersList));
    }

    private static List<Integer> readIntList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String getResult(List<Integer> firstNumbersList, List<Integer> secondNumbersList) {
        List<Integer> resultIntList = getResultIntList(firstNumbersList, secondNumbersList);

        int minValue = findMinValue(firstNumbersList, secondNumbersList);
        int maxValue = findMaxValue(firstNumbersList, secondNumbersList);

        Collections.sort(resultIntList);

        return resultIntList
                .stream()
                .filter(e -> e > minValue && e < maxValue)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static List<Integer> getResultIntList(List<Integer> firstNumbersList, List<Integer> secondNumbersList) {
        List<Integer> resultIntList = new ArrayList<>();

        int length = Math.min(firstNumbersList.size(), secondNumbersList.size());

        for (int iterate = 0; iterate < length; iterate++) {
            resultIntList.add(firstNumbersList.remove(0));
            resultIntList.add(secondNumbersList.remove(secondNumbersList.size() - 1));
        }

        return resultIntList;
    }

    private static int findMinValue(List<Integer> firstNumbersList, List<Integer> secondNumbersList) {
        return firstNumbersList.size() > secondNumbersList.size() ?
                Math.min(firstNumbersList.get(0), firstNumbersList.get(1)) :
                Math.min(secondNumbersList.get(0), secondNumbersList.get(1));
    }

    private static int findMaxValue(List<Integer> firstNumbersList, List<Integer> secondNumbersList) {
        return firstNumbersList.size() > secondNumbersList.size() ?
                Math.max(firstNumbersList.get(0), firstNumbersList.get(1)) :
                Math.max(secondNumbersList.get(0), secondNumbersList.get(1));
    }
}
