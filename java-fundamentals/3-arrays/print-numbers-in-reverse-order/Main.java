import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = readInputNumber(scanner);

        int[] numbersArray = readInputArray(scanner, number);

        System.out.println(getResult(numbersArray));

    }

    private static int readInputNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static int[] readInputArray(Scanner scanner, int number) {

        int[] tempArray = new int[number];

        for (int i = 0; i < number; i++) {

            tempArray[i] = Integer.parseInt(scanner.nextLine());

        }

        return tempArray;

    }

    private static String getResult(int[] numbersArray) {

        StringBuilder sb = new StringBuilder();

        for (int i = numbersArray.length - 1; i >= 0 ; i--) {
            sb.append(numbersArray[i]).append(" ");
        }

        return sb.toString().trim();

    }
}