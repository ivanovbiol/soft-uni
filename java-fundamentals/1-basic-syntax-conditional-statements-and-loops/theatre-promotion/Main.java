import java.util.Scanner;

public class Main {

    private static final String ERROR_MESSAGE = "Error!";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // When we have several lines of input we need to add the Scanner as parameter
        // otherwise each method won't read the new lines of input
        String day = readName(scanner);
        int age = readAge(scanner);

        System.out.println(gerResult(day, age));

    }

    private static String readName(Scanner scanner) {

        return scanner.nextLine();

    }

    private static int readAge(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static double readGrade() {

        return Double.parseDouble(new Scanner(System.in).nextLine());

    }

    private static String gerResult(String day, int age) {

        int price = 0;

        if (age >= 0 && age <= 18) {

            switch (day) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 5;
                    break;
            }

            return String.format("%d$", price);

        } else if (age > 18 && age <= 64) {

            switch (day) {
                case "Weekday":
                    price = 18;
                    break;
                case "Weekend":
                    price = 20;
                    break;
                case "Holiday":
                    price = 12;
                    break;
            }

            return String.format("%d$", price);

        } else if (age > 64 && age <= 122) {

            switch (day) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 10;
                    break;
            }

            return String.format("%d$", price);

        }

        return ERROR_MESSAGE;

    }
}