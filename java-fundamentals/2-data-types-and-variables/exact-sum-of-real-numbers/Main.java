import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numbersCount = Integer.parseInt(scanner.nextLine());

        BigDecimal bigDecimal = new BigDecimal(0);

        for (int i = 0; i < numbersCount; i++) {

            BigDecimal number = new BigDecimal(scanner.nextLine());

            bigDecimal = bigDecimal.add(number);

        }

        System.out.println(bigDecimal.toString());

    }
}