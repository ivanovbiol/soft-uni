import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = readIntNumber(scanner);

        List<String> productsList = readProductsList(scanner, number);

        System.out.println(getResult(productsList));

    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static List<String> readProductsList(Scanner scanner, int number) {
        List<String> productsList = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            productsList.add(readStringInput(scanner));
        }
        return productsList;
    }

    private static String getResult(List<String> productsList) {
        Collections.sort(productsList);

        StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0; index < productsList.size(); index++) {
            stringBuilder
                    .append(index + 1)
                    .append(".")
                    .append(productsList.get(index))
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}