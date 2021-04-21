import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String TRUE_MESSAGE = "true";
    private static final String FALSE_MESSAGE = "false";
    private static final String END_MESSAGE = "END";

    public static void main(String[] args) {

        List<Integer> integerList = readIntNumbers();

        getAndPrintResult(integerList);

    }

    private static List<Integer> readIntNumbers() {

        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = new ArrayList<>();

        String nextLine = scanner.nextLine();

        while (!END_MESSAGE.equals(nextLine)) {

            integerList.add(Integer.parseInt(nextLine));

            nextLine = scanner.nextLine();

        }

        return integerList;

    }

    private static void getAndPrintResult(List<Integer> integerList) {

        integerList
                .forEach(e -> System.out.println(isPalindrome(e)));

    }

    private static String isPalindrome(int number) {

        if (number >= 0 && number < 10) {
            return TRUE_MESSAGE;
        }

        int reversedNumber = reverseNumber(number);

        if (number == reversedNumber) {
            return TRUE_MESSAGE;
        }

        return FALSE_MESSAGE;

    }

    private static int reverseNumber(int number) {

        return Integer
                .parseInt(new StringBuilder(String.valueOf(number)).reverse().toString());

    }
}