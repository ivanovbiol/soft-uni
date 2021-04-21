import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = readInteger(scanner);

        String biggestKegName = readString(scanner);
        double biggestKegRadius = readDouble(scanner);
        int biggestKegHeight = readInteger(scanner);

        for (int i = 0; i < number - 1; i++) {

            String nextKegName = readString(scanner);
            double nextKegRadius = readDouble(scanner);
            int nextKegHeight = readInteger(scanner);

            if (nextKegIsBigger(biggestKegRadius, biggestKegHeight, nextKegRadius,
                    nextKegHeight)) {

                biggestKegName = nextKegName;
                biggestKegRadius = nextKegRadius;
                biggestKegHeight = nextKegHeight;

            }

        }

        System.out.println(biggestKegName);

    }

    private static int readInteger(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static String readString(Scanner scanner) {

        return scanner.nextLine();

    }

    private static double readDouble(Scanner scanner) {

        return Double.parseDouble(scanner.nextLine());

    }

    private static boolean nextKegIsBigger(double biggestKegRadius, int biggestKegHeight,
            double nextKegRadius, int nextKegHeight) {

        return (Math.PI * Math.pow(nextKegRadius, 2) * nextKegHeight) > (Math.PI * Math
                .pow(biggestKegRadius, 2) * biggestKegHeight);

    }
}