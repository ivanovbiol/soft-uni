import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> firstIntList = readIntList(scanner);
        List<Integer> secondIntList = readIntList(scanner);

        System.out.println(getResult(firstIntList, secondIntList));

    }

    private static List<Integer> readIntList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String getResult(List<Integer> firstIntList, List<Integer> secondIntList) {
        List<Integer> resultList = new ArrayList<>();

        int length = Math.min(firstIntList.size(), secondIntList.size());

        for (int index = 0; index < length; index++) {
            resultList.add(firstIntList.remove(0));
            resultList.add(secondIntList.remove(0));
        }

        resultList.addAll(firstIntList.size() != 0 ? firstIntList : secondIntList);

        return resultList
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}