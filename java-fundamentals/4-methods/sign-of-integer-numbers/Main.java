import java.util.Scanner;

public class Main {

    private static final String PRINT_TEMPLATE = "The number %d is %s.";
    private static final String POSITIVE_TEMPLATE = "positive";
    private static final String NEGATIVE_TEMPLATE = "negative";
    private static final String ZERO_TEMPLATE = "zero";

    public static void main(String[] args) {

        int number = readIntNumber();

        printResult(number);
    }

    private static int readIntNumber() {

        return Integer.parseInt(new Scanner(System.in).nextLine());

    }

    private static void printResult(int number) {

        System.out.printf(PRINT_TEMPLATE, number,
                number == 0 ? ZERO_TEMPLATE :
                        number < 0 ? NEGATIVE_TEMPLATE : POSITIVE_TEMPLATE);

    }
}