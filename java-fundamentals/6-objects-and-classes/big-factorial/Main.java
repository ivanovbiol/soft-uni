import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number = readIntNumber();

        System.out.println(getFactorial(number));
    }

    private static int readIntNumber() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    private static String getFactorial(int number) {

        BigInteger factorial = new BigInteger(String.valueOf(1));

        //I will solve this task with for loop
        for (int i = 2; i <= number; i++) {
            factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
        }

        return factorial.toString();
    }
}
