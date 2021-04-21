import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int number = readIntNumber(scanner);
        Set<String> chemicalElementsSet = generateSet(scanner, number);

        System.out.println(getSortedString(chemicalElementsSet));
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static Set<String> generateSet(Scanner scanner, int number) {
        Set<String> chemicalElementsSet = new TreeSet<>();

        while (number-- > 0) {
            String[] chemicalsArray = readStringArray(scanner);
            chemicalElementsSet.addAll(Arrays.asList(chemicalsArray));
        }

        return chemicalElementsSet;
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static String getSortedString(Set<String> chemicalElementsSet) {
        return chemicalElementsSet
                .stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(" "));
    }
}