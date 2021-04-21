import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int number = readIntNumber();

        System.out.println(getMatrix(number));

    }

    private static int readIntNumber() {

        return Integer.parseInt(new Scanner(System.in).nextLine());

    }

    private static String getMatrix(int number) {

       StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number; i++) {

            sb.append(getOneLine(number));

        }

        return sb.toString().trim();

    }

    private static String getOneLine(int number) {

        return ((number + " ").repeat(number)).trim() + System.lineSeparator();

    }
}