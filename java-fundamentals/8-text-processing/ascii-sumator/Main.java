import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        char firstChar = readCharInput(scanner);
        char secondChar = readCharInput(scanner);
        String inputString = readStringInput(scanner);

        int startChar = Math.min(firstChar, secondChar);
        int stopChar = Math.max(firstChar, secondChar);

        int sum = 0;

        for (int index = 0; index < inputString.length(); index++) {
            char currentChar = inputString.charAt(index);

            if (currentChar > startChar && currentChar < stopChar) {
                sum += currentChar;
            }
        }

        System.out.println(sum);
    }

    private static char readCharInput(Scanner scanner) {
        return scanner.nextLine().charAt(0);
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
