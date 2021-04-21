import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        ArrayDeque<Integer> numbers = readNumbersAsStack();

        System.out.println(getNumbers(numbers));
    }

    private static ArrayDeque<Integer> readNumbersAsStack() {
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(numbers::push);

        return numbers;
    }

    private static String getNumbers(ArrayDeque<Integer> numbers) {
        return numbers
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
