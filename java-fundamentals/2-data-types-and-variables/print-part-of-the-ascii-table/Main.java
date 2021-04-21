import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        System.out.println(
                IntStream
                        .range(start, end + 1)
                        .mapToObj(Character::toChars)
                        .map(String::new)
                        .collect(Collectors.joining(" ")));

    }
}