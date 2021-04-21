import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(getResult(readYield()));

    }

    private static int readYield() {

        return Integer.parseInt(new Scanner(System.in).nextLine());

    }

    private static String getResult(int yield) {

        int totalYield = 0;

        int daysCounter = 0;

        while (yield >= 100) {

            totalYield += yield - 26;

            yield -= 10;

            daysCounter++;
        }

        if (totalYield > 0) {

            totalYield -= 26;

        }

        return daysCounter + System.lineSeparator() + totalYield;

    }
}