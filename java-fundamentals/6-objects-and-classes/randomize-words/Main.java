import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String[] inputWords = readStringArray();

        System.out.println(getResult(inputWords));
    }

    private static String[] readStringArray() {
        return new Scanner(System.in).nextLine().split("\\s+");
    }

    private static String getResult(String[] inputWords) {
        Random random = new Random();

        for (int index = 0; index < inputWords.length; index++) {
            int randomNumber = random.nextInt(inputWords.length);
            String tempString = inputWords[index];
            inputWords[index] = inputWords[randomNumber];
            inputWords[randomNumber] = tempString;
        }

        return Arrays
                .stream(inputWords)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
