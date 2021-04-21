import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String VOWELS_STRING = "aeiouAEIOU";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfLines = readIntNumber(scanner);

        String[] inputStringsArray = readInputStringsArray(scanner, numberOfLines);

        encryptSortAndPrintResult(inputStringsArray);

    }

    private static int readIntNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static String[] readInputStringsArray(Scanner scanner, int numberOfLines) {

        String[] inputStringsArray = new String[numberOfLines];

        for (int i = 0; i < numberOfLines; i++) {

            inputStringsArray[i] = scanner.nextLine();

        }

        return inputStringsArray;

    }

    private static void encryptSortAndPrintResult(String[] inputStringsArray) {

        int[] resultArray = new int[inputStringsArray.length];

        for (int i = 0; i < resultArray.length; i++) {

            final int finalPosition = i;

            Arrays
                    .stream(inputStringsArray[finalPosition]
                            .chars()
                            .mapToObj(e -> (char) e)
                            .toArray())
                    .forEach(e -> {

                        resultArray[finalPosition] +=
                                VOWELS_STRING.contains(String.valueOf(e)) ?
                                        (char) e * inputStringsArray[finalPosition].length() :
                                        (char) e / inputStringsArray[finalPosition].length();

                    });

        }

        Arrays.sort(resultArray);

        System.out.println(Arrays
                .stream(resultArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));

    }
}