import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(getMessage());

    }

    private static String getMessage() {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        boolean isThereNextLine = true;

        int number = Integer.parseInt(scanner.nextLine());

        while (isThereNextLine) {

            if (number == 0) {

                sb.append(" ");
                number = Integer.parseInt(scanner.nextLine());
                continue;

            }

            try {

                int digitsNumber = String.valueOf(number).length();
                int mainDigit = number % 10;
                int offset = (mainDigit - 2) * 3;
                offset += mainDigit == 8 || mainDigit == 9 ? 1 : 0;
                int letterIndex = offset + digitsNumber - 1;

                char currentChar = (char) (letterIndex + 97);

                sb.append(currentChar);

                number = Integer.parseInt(scanner.nextLine());

            } catch (Exception exception) {

                isThereNextLine = false;

            }

        }

        return sb.toString();

    }
}