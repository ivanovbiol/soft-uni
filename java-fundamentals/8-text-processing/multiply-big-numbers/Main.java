import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        BigDecimal firstBigDecimal = readBigDecimalNumber(scanner);
        BigDecimal secondBigDecimal = readBigDecimalNumber(scanner);

        System.out.println(
                new DecimalFormat("#.####")
                        .format(firstBigDecimal.multiply(secondBigDecimal)));
    }

    private static BigDecimal readBigDecimalNumber(Scanner scanner) {
        return new BigDecimal(scanner.nextLine());
    }
}
