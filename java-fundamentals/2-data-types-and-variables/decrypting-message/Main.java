import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int key = readInputNumber(scanner);
        int numberOfLines = readInputNumber(scanner);

        System.out.println(getResult(scanner, key, numberOfLines));

    }

    private static int readInputNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static char readInputCharacter(Scanner scanner) {

        return scanner.nextLine().charAt(0);

    }

    private static String getResult(Scanner scanner, int key, int numberOfLines) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numberOfLines; i++) {

            char currentChar = readInputCharacter(scanner);

            stringBuilder.append((char) (currentChar + key));
        }

        return stringBuilder.toString();

    }
}