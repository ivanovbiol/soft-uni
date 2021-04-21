import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(getResult(scanner));
    }

    private static String getResult(Scanner scanner) {

        return new BigInteger(scanner.nextLine())
                .add(new BigInteger(scanner.nextLine()))
                .toString();
    }
}
