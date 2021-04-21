import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Deque<Integer> data = new ArrayDeque<>();

        int number = readIntNumber();

        if (number == 0) {
            data.push(0);
        }

        while (number != 0) {
            data.push(number % 2);

            number /= 2;
        }

        data.forEach(System.out::print);
    }

    private static int readIntNumber() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
}
