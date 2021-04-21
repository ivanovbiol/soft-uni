import java.util.Scanner;

public class Main {

    private static final String INSUFFICIENT_CAPACITY = "Insufficient capacity!";
    private static final int TANK_CAPACITY = 255;

    public static void main(String[] args) {

        printResult();

    }

    private static void printResult() {

        Scanner scanner = new Scanner(System.in);

        int linesOfInput = readInteger(scanner);

        int pouredLiters = 0;

        while (linesOfInput-- > 0) {

            int litersAdded = readInteger(scanner);

            if (pouredLiters + litersAdded > TANK_CAPACITY) {
                System.out.println(INSUFFICIENT_CAPACITY);
            } else {
                pouredLiters += litersAdded;
            }

        }

        System.out.println(pouredLiters);

    }

    private static int readInteger(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }
}