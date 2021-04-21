import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int inputNumber = Integer.parseInt(scanner.nextLine());

        for (int currentNumber = 1; currentNumber <= inputNumber; currentNumber++) {

            int sum = 0;
            int tempNumber = currentNumber;

            while (tempNumber > 0) {

                int lastDigit = tempNumber % 10;

                sum += lastDigit;

                tempNumber /= 10;

            }

            boolean isSpecial = sum == 5 || sum == 7 || sum == 11;

            String trueOrFalseMessage =
                    String.valueOf(isSpecial).substring(0, 1).toUpperCase() + String
                            .valueOf(isSpecial).substring(1).toLowerCase();

            System.out.printf("%d -> %s%n", currentNumber, trueOrFalseMessage);

        }
    }
}