import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        String toRemove = readStringInput(scanner);
        String word = readStringInput(scanner);

        while (word.contains(toRemove)) {
            word = word.replaceAll(toRemove, "");
        }

        System.out.println(word);
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
