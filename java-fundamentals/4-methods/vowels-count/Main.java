import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String VOWELS_LETTERS = "aeiouAEIOU";

    public static void main(String[] args) {

        String inputString = readInputString();

        System.out.println(countVowelsCount(inputString));

    }

    private static String readInputString() {

        return new Scanner(System.in).nextLine();

    }

    private static int countVowelsCount(String inputString) {

        int[] count = new int[1];

        Arrays
                .stream(inputString.split(""))
                .forEach(e -> {
                    count[0] += VOWELS_LETTERS.contains(e) ? 1 : 0;
                });

        return count[0];

    }
}