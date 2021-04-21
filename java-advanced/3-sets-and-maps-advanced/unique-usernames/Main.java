import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = readIntNumber(scanner);
        Set<String> usernameSet = generateSet(scanner, numberOfLines);
        printSet(usernameSet);
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static Set<String> generateSet(Scanner scanner, int numberOfLines) {
        Set<String> usernameSet = new LinkedHashSet<>();

        while (numberOfLines-- > 0) {
            usernameSet.add(readStringInput(scanner));
        }

        return usernameSet;
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void printSet(Set<String> usernameSet) {
        usernameSet
                .forEach(System.out::println);
    }
}