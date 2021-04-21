import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String END = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> train = readIntList(scanner);

        int maxCapacity = readIntNumber(scanner);

        processCommandsAndPrintResult(scanner, train, maxCapacity);
    }

    private static List<Integer> readIntList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String readNextLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void processCommandsAndPrintResult(Scanner scanner, List<Integer> train,
            int maxCapacity) {
        String nextLine = readNextLine(scanner);

        while (!END.equals(nextLine)) {

            if (nextLine.contains("Add")) {
                addWagon(train, Integer.parseInt(nextLine.split("\\s+")[1]));
            } else {
                addPassengers(train, Integer.parseInt(nextLine), maxCapacity);
            }

            nextLine = readNextLine(scanner);

        }

        System.out.println(
                train
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")));

    }

    private static void addWagon(List<Integer> train, int passengers) {
        train.add(passengers);
    }

    private static void addPassengers(List<Integer> train, int numberOfPeople, int maxCapacity) {
        for (int i = 0; i < train.size(); i++) {

            if (train.get(i) + numberOfPeople <= maxCapacity) {
                train.set(i, train.get(i) + numberOfPeople);
                return;
            }

        }
    }

}