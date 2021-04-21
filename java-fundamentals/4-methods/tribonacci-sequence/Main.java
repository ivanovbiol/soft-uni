import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    // I will solve this task with array
    public static void main(String[] args) {

        int num = readIntNumber();

        System.out.println(getResult(num));

    }

    private static int readIntNumber() {

        return Integer.parseInt(new Scanner(System.in).nextLine());

    }

    private static String getResult(int num) {

        if (num == 0) {
            return String.valueOf(0);
        } else if (num == 1) {
            return String.valueOf(1);
        } else if (num == 2) {
            return "1 1";
        } else {

            int[] tribonacciArray = new int[num];

            tribonacciArray[0] = 1;
            tribonacciArray[1] = 1;
            tribonacciArray[2] = 2;

            for (int index = 3; index < tribonacciArray.length; index++) {
                tribonacciArray[index] =
                                tribonacciArray[index - 1] +
                                tribonacciArray[index - 2] +
                                tribonacciArray[index - 3];
            }

            return Arrays
                    .stream(tribonacciArray)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
        }
    }
}