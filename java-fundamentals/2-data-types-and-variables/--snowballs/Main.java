import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(findBestSnowballsParameters());

    }

    private static String findBestSnowballsParameters() {

        Scanner scanner = new Scanner(System.in);

        int numberOfSnowballsInput = readInteger(scanner);

        int bestSnowballSnow = readInteger(scanner);
        int bestSnowballTime = readInteger(scanner);
        int bestSnowballQuality = readInteger(scanner);

        double bestSnowballValue = Math
                .pow((bestSnowballSnow * 1.0 / bestSnowballTime), bestSnowballQuality);

        for (int i = 0; i < numberOfSnowballsInput - 1; i++) {

            int nextSnowballSnow = readInteger(scanner);
            int nextSnowballTime = readInteger(scanner);
            int nextSnowballQuality = readInteger(scanner);

            double nextSnowballValue = Math
                    .pow((nextSnowballSnow * 1.0 / nextSnowballTime), nextSnowballQuality);

            if (nextSnowballValue > bestSnowballValue) {
                bestSnowballSnow = nextSnowballSnow;
                bestSnowballTime = nextSnowballTime;
                bestSnowballQuality = nextSnowballQuality;

                bestSnowballValue = nextSnowballValue;
            }
        }

        return String.format("%d : %d = %.0f (%d)", bestSnowballSnow, bestSnowballTime,
                bestSnowballValue, bestSnowballQuality);

    }

    private static int readInteger(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }
}