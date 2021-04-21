import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String EMPTY_MESSAGE = "empty";

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

    private static String getResult(List<Integer> productsList) {
        Collections.reverse(productsList);

        String positiveNumbersString = productsList
                .stream()
                .filter(e -> e >= 0)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        return positiveNumbersString.length() != 0 ? positiveNumbersString : EMPTY_MESSAGE;
    }
}