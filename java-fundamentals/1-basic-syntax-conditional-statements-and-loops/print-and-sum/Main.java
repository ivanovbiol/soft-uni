import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final String SUM_TEMPLATE = "Sum: %d";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // When we have several lines of input we need to add the Scanner as parameter
        // otherwise each method won't read the new lines of input
        int startNumber = readInputNumber(scanner);
        int endNumber = readInputNumber(scanner);

        System.out.println(getResult(startNumber, endNumber));

    }

    private static int readInputNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static String getResult(int startNumber, int endNumber) {

        StringBuilder sb = new StringBuilder();

        // creating a List with all numbers
        List<Integer> integerList = IntStream.range(startNumber, endNumber + 1)
                .boxed().collect(Collectors.toList());

        // appending all the numbers from the List to the StringBuilder with delimiter " " (space)
        sb.append(integerList
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

        sb.append(System.lineSeparator());

        // appending the sum of all the elements from the List to the StringBuilder
        sb.append(
                String.format(SUM_TEMPLATE, integerList.stream().mapToInt(Integer::valueOf).sum()));

        return sb.toString();

    }
}