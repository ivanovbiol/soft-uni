import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        String[] input = readInputArray();

        String firstString = input[0];
        String secondString = input[1];

        int length = Math.min(firstString.length(), secondString.length());

        int totalSum = findTotalSum(firstString, secondString, length);

        System.out.println(totalSum);
    }

    private static String[] readInputArray() {
        return new Scanner(System.in).nextLine().split("\\s+");
    }

    private static int findTotalSum(String firstString, String secondString, int length) {
        int totalSum = 0;

        for (int index = 0; index < length; index++) {
            totalSum += firstString.charAt(index) * secondString.charAt(index);
        }

        if (firstString.length() < secondString.length()) {
            for (int index = length; index < secondString.length(); index++) {
                totalSum += secondString.charAt(index);
            }
        } else if (secondString.length() < firstString.length()) {
            for (int index = length; index < firstString.length(); index++) {
                totalSum += firstString.charAt(index);
            }
        }

        return totalSum;
    }
}
