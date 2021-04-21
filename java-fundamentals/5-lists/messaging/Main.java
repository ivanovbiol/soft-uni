import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = readIntList(scanner);

        List<String> stringsList = readStringList(scanner);

        System.out.println(getResult(numbersList, stringsList));
    }

    private static List<Integer> readIntList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<String> readStringList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());
    }

    private static String getResult(List<Integer> numbersList, List<String> stringsList) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int position = 0; position < numbersList.size(); position++) {
            int index = findIndexFromIntList(numbersList.get(position));

            while (index >= stringsList.size()) {
                index -= stringsList.size();
            }

            stringBuilder.append(stringsList.remove(index));
        }
        return stringBuilder.toString();
    }

    private static int findIndexFromIntList(int number) {
        return String
                .valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
