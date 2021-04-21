import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Queue<String> data = readStringInput();

        double result = Double.parseDouble(data.poll());

        while (!data.isEmpty()) {
            char operator = data.poll().charAt(0);
            double nextNumber = Double.parseDouble(data.poll());

            if (operator == '+') {
                result += nextNumber;
            } else {
                result -= nextNumber;
            }
        }

        System.out.println(new DecimalFormat("#.####").format(result));
    }

    private static Queue<String> readStringInput() {
        Queue<String> data = new ArrayDeque<>();

        Stream
                .of(new Scanner(System.in).nextLine().split("\\s+"))
                .forEach(data::offer);

        return data;
    }
}
