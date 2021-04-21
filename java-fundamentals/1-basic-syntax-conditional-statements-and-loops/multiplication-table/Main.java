import java.util.Scanner;

public class Main {

    private static final String MULTIPLICATION_FORMAT_STRING = "%d X %d = %d";

    public static void main(String[] args) {

        int number = readInputNumber();

        System.out.println(getResult(number));

    }

    private static int readInputNumber() {

        return Integer.parseInt(new Scanner(System.in).nextLine());

    }

    private static String getResult(int number) {

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {

            sb.append(String.format(MULTIPLICATION_FORMAT_STRING, number, i, (number * i)))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();

    }
}