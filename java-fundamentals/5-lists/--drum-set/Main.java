import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String HIT_AGAIN_MESSAGE = "Hit it again, Gabsy!";
    private static final String OUTPUT_MESSAGE_TEMPLATE = "Gabsy has %.2flv.";
    private static final List<Integer> INITIAL_QUALITY_DRUM_SET = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = readDoubleNumber(scanner);
        List<Integer> drumsList = readIntList(scanner);

        copyValuesToInitialQualityDrumSet(drumsList);

        System.out.println(getResult(savings, drumsList, scanner));
    }

    private static double readDoubleNumber(Scanner scanner) {
        return Double.parseDouble(scanner.nextLine());
    }

    private static List<Integer> readIntList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void copyValuesToInitialQualityDrumSet(List<Integer> drumsList) {
        INITIAL_QUALITY_DRUM_SET.addAll(drumsList);
    }

    private static String getResult(double savings, List<Integer> drumsList, Scanner scanner) {
        String nextLine = readStringInput(scanner);

        while (!HIT_AGAIN_MESSAGE.equals(nextLine)) {
            int hitPower = Integer.parseInt(nextLine);

            hitAllDrums(drumsList, hitPower);

            if (areThereBrokenDrums(drumsList)) {
                savings = repairBrokenDrumsAndReturnSavings(drumsList, savings);
            }

            nextLine = readStringInput(scanner);
        }

        return getOutputMessage(drumsList, savings);
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void hitAllDrums(List<Integer> drumsList, int hitPower) {
        for (int index = 0; index < drumsList.size(); index++) {
            if (drumsList.get(index) == Integer.MAX_VALUE) {
                continue;
            }
            drumsList.set(index, drumsList.get(index) - hitPower);
        }
    }

    private static boolean areThereBrokenDrums(List<Integer> drumsList) {
        for (Integer current : drumsList) {
            if (current <= 0) {
                return true;
            }
        }
        return false;
    }

    private static double repairBrokenDrumsAndReturnSavings(List<Integer> drumsList,
            double savings) {
        for (int index = 0; index < drumsList.size(); index++) {
            if (drumsList.get(index) <= 0) {
                int sumForRepairment = INITIAL_QUALITY_DRUM_SET.get(index) * 3;

                if (sumForRepairment <= savings) {
                    drumsList.set(index, INITIAL_QUALITY_DRUM_SET.get(index));
                    savings -= sumForRepairment;
                } else {
                    drumsList.set(index, Integer.MAX_VALUE);
                }

            }
        }

        return savings;
    }

    private static String getOutputMessage(List<Integer> drumsList, double savings) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(drumsList
                            .stream()
                            .filter(e -> e != Integer.MAX_VALUE)
                            .map(String::valueOf)
                            .collect(Collectors.joining(" ")))
                .append(System.lineSeparator())
                .append(String.format(OUTPUT_MESSAGE_TEMPLATE, savings));

        return stringBuilder.toString();
    }
}
