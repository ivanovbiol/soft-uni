import java.util.Scanner;

public class Main {

    private static final String CHAR = "char";
    private static final String STRING = "string";
    private static final String INT = "int";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String type = readStringInput(scanner);

        calculateAndPrintResult(type, scanner);

    }

    private static String readStringInput(Scanner scanner) {

        return scanner.nextLine();

    }

    private static char readCharInput(Scanner scanner) {

        return scanner.nextLine().charAt(0);

    }

    private static int readIntNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static void calculateAndPrintResult(String type, Scanner scanner) {

        switch (type) {
            case CHAR:

                char firstChar = readCharInput(scanner);
                char secondChar = readCharInput(scanner);
                System.out.println(getMax(firstChar, secondChar));

                break;
            case INT:

                int firstInt = readIntNumber(scanner);
                int secondInt = readIntNumber(scanner);
                System.out.println(getMax(firstInt, secondInt));

                break;
            case STRING:

                String firstString = readStringInput(scanner);
                String secondString = readStringInput(scanner);
                System.out.println(getMax(firstString, secondString));

                break;
        }

    }

    private static char getMax(char firstChar, char secondChar) {

        return (char) Math.max(firstChar, secondChar);

    }

    private static int getMax(int firstInt, int secondInt) {

        return Math.max(firstInt, secondInt);

    }

    private static String getMax(String firstString, String secondString) {

        return firstString.compareTo(secondString) < 0 ? secondString :
                firstString.compareTo(secondString) == 0 ?
                        firstString : firstString;

    }
}