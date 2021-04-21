import java.util.Scanner;

public class Main {

    private static final String OUTPUT_FORMAT = "Town %s has population of %d and area %d square km.";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        int area = Integer.parseInt(scanner.nextLine());

        System.out.printf(OUTPUT_FORMAT, name, population, area);

    }
}