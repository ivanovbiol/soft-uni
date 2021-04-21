import java.util.Scanner;

public class Main {

    private static final String THE_NUMBER_IS_DIVISIBLE_BY = "The number is divisible by %d";
    private static final String NOT_DIVISIBLE = "Not divisible";

    public static void main(String[] args) {

        int number = readInputNumber();

        System.out.println(getResult(number));

    }

    private static int readInputNumber() {

        return Integer.parseInt(new Scanner(System.in).nextLine());

    }

    private static String getResult(int number) {

        if (number % 10 == 0) {
            return String.format(THE_NUMBER_IS_DIVISIBLE_BY, 10);
        } else if (number % 7 == 0) {
            return String.format(THE_NUMBER_IS_DIVISIBLE_BY, 7);
        } else if (number % 6 == 0) {
            return String.format(THE_NUMBER_IS_DIVISIBLE_BY, 6);
        } else if (number % 3 == 0) {
            return String.format(THE_NUMBER_IS_DIVISIBLE_BY, 3);
        } else if (number % 2 == 0) {
            return String.format(THE_NUMBER_IS_DIVISIBLE_BY, 2);
        } else {
            return NOT_DIVISIBLE;
        }

    }
}