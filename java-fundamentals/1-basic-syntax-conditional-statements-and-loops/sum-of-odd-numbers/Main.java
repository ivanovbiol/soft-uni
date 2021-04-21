import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int number = Integer.parseInt(new Scanner(System.in).nextLine());

        int sum = 0;

        for (int i = 1; i <= 2 * number; i += 2) {

            sum += i;

            System.out.println(i);

        }

        System.out.println("Sum: " + sum);

    }
}