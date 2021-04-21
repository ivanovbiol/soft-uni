import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int end = Integer.parseInt(scanner.nextLine());

        for (int currentNumber = 2; currentNumber <= end; currentNumber++) {

            boolean isPrime = isPrimeCurrentNumber(currentNumber);

            System.out.printf("%d -> %b", currentNumber, isPrime).println();

        }

    }

    private static boolean isPrimeCurrentNumber(int currentNumber) {

        return (currentNumber == 2 || currentNumber == 3) ? true :
                (currentNumber % 2 != 0 && currentNumber % 3 != 0) ? true : false;

    }
}