import java.util.Scanner;

public class Main {

    private static final String INT_TYPE = "int";
    private static final String DOUBLE_TYPE = "real";
    private static final String STRING_TYPE = "string";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String typeOfInput = readStringInput(scanner);

        System.out.println(getResult(typeOfInput, scanner));

    }

    private static String readStringInput(Scanner scanner) {

        return scanner.nextLine();

    }

    private static int readIntNumber(Scanner scanner) {

        return Math.abs(Integer.parseInt(scanner.nextLine()));

    }

    private static double readDoubleNumber(Scanner scanner) {

        return Double.parseDouble(scanner.nextLine());

    }

    private static String getResult(String typeOfInput, Scanner scanner) {

        String result = "";

        switch (typeOfInput) {
            case INT_TYPE:

                int intNumber = readIntNumber(scanner);
                result = String.valueOf(intNumber * 2);

                break;
            case DOUBLE_TYPE:

                double doubleNumber = readDoubleNumber(scanner);
                result = String.format("%.2f", doubleNumber * 1.5);

                break;
            case STRING_TYPE:

                result = "$" + readStringInput(scanner) + "$";

                break;
        }

        return result;

    }
}