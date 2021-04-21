import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbersList = readIntList();

        System.out.println(getResult(numbersList));

    }

    private static List<Integer> readIntList() {
        return Arrays
                .stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String getResult(List<Integer> numbersList) {
        for (int index = 0; index < numbersList.size() - 1; index++) {
            // First + Last list element
            numbersList.set(index,
                    numbersList.get(index) + numbersList.remove(numbersList.size() - 1));
        }

        return numbersList
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}