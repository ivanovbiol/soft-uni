import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = readIntArray(scanner);
        generateAndPrintSets(scanner, numbers);
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void generateAndPrintSets(Scanner scanner, int[] numbers) {
        int firstSetLength = numbers[0];
        int secondSetLength = numbers[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        while (firstSetLength-- > 0) {
            firstSet.add(readIntNumber(scanner));
        }

        while (secondSetLength-- > 0) {
            secondSet.add(readIntNumber(scanner));
        }

        Set<Integer> resultingSet = new LinkedHashSet<>();

        firstSet
                .forEach(e -> {
                    if (secondSet.contains(e)) {
                        resultingSet.add(e);
                    }
                });

        System.out.println(
                resultingSet
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")));
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}