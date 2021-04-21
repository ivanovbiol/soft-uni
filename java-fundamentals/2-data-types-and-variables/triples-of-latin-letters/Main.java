import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                for (int k = 0; k < number; k++) {
                    sb.append( (char) ('a' + i) );
                    sb.append( (char) ('a' + j) );
                    sb.append( (char) ('a' + k) );
                    sb.append(System.lineSeparator());
                }
            }
        }

        System.out.println(sb.toString().trim());

    }
}