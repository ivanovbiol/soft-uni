import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Double> numbersList = readDoubleList();

        System.out.println(getResult(numbersList));

    }

    private static List<Double> readDoubleList() {
        return Arrays
                .stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    private static String getResult(List<Double> numbersList) {

        // Maybe it's not the best idea to set the index = -1 and while loop could be better choice
        for (int index = 0; index < numbersList.size() - 1; index++) {

            if (numbersList.get(index).equals(numbersList.get(index + 1))) {
                numbersList.set(index, numbersList.get(index) + numbersList.remove(index + 1));

                // After the if statement incrementation takes place and index == 0
                index = -1;
            }

        }

        return numbersList
                .stream()
                .map(e -> new DecimalFormat("0.###").format(e))
                .collect(Collectors.joining(" "));

    }
}