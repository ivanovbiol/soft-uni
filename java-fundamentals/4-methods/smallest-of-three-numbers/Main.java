import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Integer> integerList = readNumbers();

        System.out.println(smallestNumberFromList(integerList));

    }

    private static List<Integer> readNumbers() {

        List<Integer> integerList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // I don't want to use scanner.hasNextLine()
        while (true) {

            try {
                integerList.add(Integer.parseInt(scanner.nextLine()));
            } catch (Exception exception) {
                break;
            }

        }

        return integerList;

    }

    private static int smallestNumberFromList(List<Integer> integerList) {

        Collections.sort(integerList);

        return integerList.get(0);

    }
}