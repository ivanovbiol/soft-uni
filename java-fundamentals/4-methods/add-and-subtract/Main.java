import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNumber = readIntNumber(scanner);
        int secondNumber = readIntNumber(scanner);
        int thirdNumber = readIntNumber(scanner);

        System.out.println(
                subtract(sum(firstNumber, secondNumber), thirdNumber));


    }

    private static int readIntNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static int sum(int firstNumber, int secondNumber) {

        return firstNumber + secondNumber;

    }

    private static int subtract (int firstNumber, int secondNumber) {

        return firstNumber - secondNumber;

    }
}