import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        for (int i = 0; i < lines; i++) {

            sum += scanner.nextLine().charAt(0);

        }

        System.out.printf("The sum equals: %d", sum).println();

    }
}