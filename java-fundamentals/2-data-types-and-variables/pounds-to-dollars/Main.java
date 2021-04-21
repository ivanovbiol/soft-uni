import java.util.Scanner;

public class Main {

    private static final double POUNDS_TO_DOLLARS = 1.31;

    public static void main(String[] args) {

        System.out.printf("%.3f", Double.parseDouble(new Scanner(System.in).nextLine()) * POUNDS_TO_DOLLARS);

    }
}