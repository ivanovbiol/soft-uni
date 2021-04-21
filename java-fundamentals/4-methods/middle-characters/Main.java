import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String input = readInputString();

        System.out.println(findMiddleCharacters(input));

    }

    private static String readInputString() {

        return new Scanner(System.in).nextLine();

    }

    private static String findMiddleCharacters(String input) {

        int halfLength = input.length() / 2;

        return input.length() % 2 == 1 ?
                input.substring(halfLength, halfLength + 1) :
                input.substring(halfLength - 1, halfLength + 1);

    }
}