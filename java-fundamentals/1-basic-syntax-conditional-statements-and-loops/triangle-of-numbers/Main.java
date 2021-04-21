import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {

            String currentAppend = i + " ";

            sb.append(currentAppend.repeat(i).trim())
                    .append(System.lineSeparator());

        }

        System.out.println(sb.toString());

    }
}