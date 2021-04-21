import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = readListOfNumbers();

        printResult(numbers);

    }

    private static List<Integer> readListOfNumbers() {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        boolean isThereNextLine = true;

        while (isThereNextLine) {

            try {

                int nextNumber = Integer.parseInt(scanner.nextLine());
                numbers.add(nextNumber);

            } catch (Exception exception) {

                isThereNextLine = false;

            }

        }

        return numbers;

    }

    private static void printResult(List<Integer> numbers) {

        numbers.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

    }
}