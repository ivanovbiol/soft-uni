import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> namesMap = addValuesAndNamesInStaticMap();

        int number = Integer.parseInt(new Scanner(System.in).nextLine());

        System.out.println(getTheNameOfLastDigit(namesMap, number));

    }

    private static Map<Integer, String> addValuesAndNamesInStaticMap() {

        return new HashMap<>(
                Map.of(0, "zero",
                        1, "one",
                        2, "two",
                        3, "three",
                        4, "four",
                        5, "five",
                        6, "six",
                        7, "seven",
                        8, "eight",
                        9, "nine"
                ));

    }

    private static String getTheNameOfLastDigit(Map<Integer, String> namesMap, int number) {

        return namesMap.get(number % 10);

    }
}