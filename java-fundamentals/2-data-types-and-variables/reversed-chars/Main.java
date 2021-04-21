import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(
                new StringBuilder()
                        .append(scanner.nextLine()).append(" ")
                        .append(scanner.nextLine()).append(" ")
                        .append(scanner.nextLine()).append(" ")
                        .reverse()
                        .toString()
                        .trim());

    }
}