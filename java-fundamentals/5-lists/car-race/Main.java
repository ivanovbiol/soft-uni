import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String PRINT_TEMPLATE = "The winner is %s with total time: %.1f";
    private static final String LEFT_TEMPLATE = "left";
    private static final String RIGHT_TEMPLATE = "right";

    public static void main(String[] args) {
        List<Integer> numbersList = readIntList();

        System.out.println(findWinner(numbersList));
    }

    private static List<Integer> readIntList() {
        return Arrays
                .stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String findWinner(List<Integer> numbersArray) {
        double firstPlayerTime =
                findTime(numbersArray.subList(0, numbersArray.size() / 2));

        Collections.reverse(numbersArray);
        
        double secondPlayerTime =
                findTime(numbersArray.subList(0, numbersArray.size() - 1));

        return firstPlayerTime < secondPlayerTime ?
                String.format(PRINT_TEMPLATE, LEFT_TEMPLATE, firstPlayerTime) :
                String.format(PRINT_TEMPLATE, RIGHT_TEMPLATE, secondPlayerTime);
    }

    private static double findTime(List<Integer> timeListForEachPlayer) {
        int countOfIterations = timeListForEachPlayer.size();
        double sum = 0;

        for (int index = 0; index < countOfIterations; index++) {
            if (timeListForEachPlayer.get(0) == 0) {
                sum *= 0.8;
                timeListForEachPlayer.remove(0);
                continue;
            }

            sum += timeListForEachPlayer.remove(0);
        }

        return sum;
    }
}
