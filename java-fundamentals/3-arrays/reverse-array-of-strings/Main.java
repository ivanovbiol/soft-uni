import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] stringArray = readStringArray();

        System.out.println(getReversedArray(stringArray));

    }

    private static String[] readStringArray() {

        return new Scanner(System.in).nextLine().split("\\s+");

    }

    private static String getReversedArray(String[] stringArray) {

        Collections.reverse(Arrays.asList(stringArray));

        return Arrays.toString(stringArray)
                .replace("[", " ")
                .replace("]", " ")
                .replace(", ", " ")
                .trim();

    }
}