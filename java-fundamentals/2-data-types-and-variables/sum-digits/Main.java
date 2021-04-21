import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(Arrays
                .stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .sum());

    }
}