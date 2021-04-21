import java.util.Scanner;

public class Main {

    private static final String MULTIPLICATION_FORMAT_STRING = "%d X %d = %d";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // When we have several lines of input we need to add the Scanner as parameter
        // otherwise each method won't read the new lines of input
        int constantMultiplier = readInputNumber(scanner);
        int startNumber = readInputNumber(scanner);

        System.out.println(getResult(constantMultiplier, startNumber));

    }

    private static int readInputNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static String getResult(int constantMultiplier, int startNumber) {

        if (startNumber <= 10) {

            StringBuilder sb = new StringBuilder();

            for (int i = startNumber; i <= 10; i++) {

                sb.append(String.format(MULTIPLICATION_FORMAT_STRING, constantMultiplier, i,
                        (constantMultiplier * i)))
                        .append(System.lineSeparator());

            }

            return sb.toString().trim();

        } else {

            return String.format(MULTIPLICATION_FORMAT_STRING, constantMultiplier, startNumber,
                    (constantMultiplier * startNumber));
        }

    }
}