//Option 1 - Fibonacci number with Memoization

import java.util.Scanner;

public class Main {

    private static final long[] FIBONACCI_ARRAY = new long[50];

    public static void main(String[] args) {

        int number = readIntNumber();

        System.out.println(getFibonacciNumber(number));

    }

    private static int readIntNumber() {

        return Integer.parseInt(new Scanner(System.in).nextLine());

    }

    private static long getFibonacciNumber(int number) {

        if (FIBONACCI_ARRAY[number] == 0) {

            if (number <= 1) {
                FIBONACCI_ARRAY[number] = number;
            } else {
                FIBONACCI_ARRAY[number] =
                        getFibonacciNumber(number - 1) + getFibonacciNumber(number - 2);
            }

        }

        return FIBONACCI_ARRAY[number];

    }
}

//  //Option 2 - Fibonacci sequence with recursion
//
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        int number = readIntNumber();
//
//        System.out.println(getFibonacciNumber(number));
//
//    }
//
//    private static int readIntNumber() {
//
//        return Integer.parseInt(new Scanner(System.in).nextLine());
//
//    }
//
//    private static int getFibonacciNumber(int number) {
//
//        return number <= 1 ? number : getFibonacciNumber(number - 1) + getFibonacciNumber(number - 2);
//
//    }
//}

//  //Option 1 - Fibonacci number with simple long Array
//
//import java.util.Scanner;
//
//public class Main {
//
//    // Fibonacci sequence with long array
//    private static long[] fibonacciSequenceArray = new long[50];
//
//    public static void main(String[] args) {
//
//        int number = readIntNumber();
//
//        fillFibonacciArray();
//
//        System.out.println(getFibonacciNumber(number - 1));
//
//    }
//
//    private static int readIntNumber() {
//
//        return Integer.parseInt(new Scanner(System.in).nextLine());
//
//    }
//
//    private static void fillFibonacciArray() {
//
//        fibonacciSequenceArray[0] = 1;
//        fibonacciSequenceArray[1] = 1;
//
//        for (int i = 2; i < fibonacciSequenceArray.length; i++) {
//            fibonacciSequenceArray[i] =
//                    fibonacciSequenceArray[i - 1] + fibonacciSequenceArray[i - 2];
//        }
//
//    }
//
//    private static long getFibonacciNumber(int number) {
//
//        return number == -1 ? 0 : fibonacciSequenceArray[number];
//
//    }
//}
