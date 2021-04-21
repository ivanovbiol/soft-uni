import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int number = readIntNumber();

        printResult(number);

    }

    private static int readIntNumber() {

        return Integer.parseInt(new Scanner(System.in).nextLine());

    }

    private static void printResult(int number) {

        StringBuilder sb = new StringBuilder();

        for (int index = 1; index <= number; index++) {
            sb.append(getOneLineFromTriangle(index));
        }

        for (int index = number - 1; index > 0; index--) {
            sb.append(getOneLineFromTriangle(index));
        }

        System.out.println(sb.toString().trim());
        
    }

    private static String getOneLineFromTriangle(int number) {

        StringBuilder sb = new StringBuilder();

        for (int index = 1; index <= number; index++) {
            sb.append(index);

            if (index < number) {
                sb.append(" ");
            }
        }

        sb.append(System.lineSeparator());

        return sb.toString();

    }
}