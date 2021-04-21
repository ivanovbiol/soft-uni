import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char firstChar = readInputChar(scanner);
        char secondChar = readInputChar(scanner);

        System.out.println(getCharsInRange(firstChar, secondChar));

    }

    private static char readInputChar(Scanner scanner) {

        return scanner.nextLine().charAt(0);

    }

    private static String getCharsInRange(char firstChar, char secondChar) {

        StringBuilder sb = new StringBuilder();

        int start = Math.min(firstChar, secondChar);
        int end = Math.max(firstChar, secondChar);

        for (int i = start + 1; i < end; i++) {

            sb.append((char) i).append(" ");

        }

        return sb.toString().trim();

    }
}