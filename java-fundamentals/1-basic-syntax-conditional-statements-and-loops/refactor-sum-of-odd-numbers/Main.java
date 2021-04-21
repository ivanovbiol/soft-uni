import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        // The sum has to be initialised with value 0 in the beginning
        int sum = 0;

        // the loop has to end < to n, instead of <= n
        for (int i = 0; i < n; i++) {

            //Each number should be printed on a new line
            System.out.println(2 * i + 1);

            // we need to add the current odd number to the sum instead only 2 * i
            sum += 2 * i + 1;

        }

        System.out.printf("Sum: %d%n", sum);

    }
}