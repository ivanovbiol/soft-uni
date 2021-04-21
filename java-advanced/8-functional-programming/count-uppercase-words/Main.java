import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    private static final String DELIMITER = "\\s+";
    private static final String PRINT_COUNT_TEMPLATE = "%d";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        String[] words = readStringArray();

        Predicate<String> isWordWithUpperCase = word -> Character.isUpperCase(word.charAt(0));
        Consumer<String> printWord = System.out::println;

        System.out.printf(PRINT_COUNT_TEMPLATE,
                findCountOfWordsWhichStartsWithCapitalLetter(words, isWordWithUpperCase)).println();

        printWordsWhichStartsWithUpperCase(words, isWordWithUpperCase, printWord);
    }

    private static String[] readStringArray() {
        return new Scanner(System.in).nextLine().split(DELIMITER);
    }

    private static int findCountOfWordsWhichStartsWithCapitalLetter(String[] words,
            Predicate<String> isWordWithUpperCase) {
        return (int) Arrays
                .stream(words)
                .filter(isWordWithUpperCase)
                .count();
    }

    private static void printWordsWhichStartsWithUpperCase(String[] words,
            Predicate<String> isWordWithUpperCase, Consumer<String> printWord) {
        Arrays
                .stream(words)
                .filter(isWordWithUpperCase)
                .forEach(printWord);
    }
}
