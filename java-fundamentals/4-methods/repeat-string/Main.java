import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String word = readStringInput(scanner);
        int repetitions = readIntNumber(scanner);

        System.out.println(getResult(word, repetitions));

    }

    private static String readStringInput(Scanner scanner) {

        return scanner.nextLine();

    }

    private static int readIntNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static String getResult(String word, int repetitions) {

        return word.repeat(repetitions);

    }
}