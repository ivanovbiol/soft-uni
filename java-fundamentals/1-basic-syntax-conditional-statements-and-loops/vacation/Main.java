import java.util.Scanner;

public class Main {

    private static final String TOTAL_PRICE_FORMAT = "Total price: %.2f";
    private static final String STUDENTS_TYPE = "Students";
    private static final String BUSINESS_TYPE = "Business";
    private static final String REGULAR_TYPE = "Regular";
    private static final String FRIDAY = "Friday";
    private static final String SATURDAY = "Saturday";
    private static final String SUNDAY = "Sunday";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // When we have several lines of input we need to add the Scanner as parameter
        // otherwise each method won't read the new lines of input
        int numberOfPeople = readInputNumber(scanner);
        String groupType = readInputString(scanner);
        String dayOfWeek = readInputString(scanner);

        System.out.println(getResult(numberOfPeople, groupType, dayOfWeek));

    }

    private static int readInputNumber(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static String readInputString(Scanner scanner) {

        return scanner.nextLine();

    }

    private static String getResult(int numberOfPeople, String groupType, String dayOfWeek) {

        double price = 0.0;

        switch (groupType) {

            case STUDENTS_TYPE:
                price = getStudentsTotalPrice(numberOfPeople, dayOfWeek);
                break;

            case BUSINESS_TYPE:
                price = getBusinessTotalPrice(numberOfPeople, dayOfWeek);
                break;

            case REGULAR_TYPE:
                price = getRegularTotalPrice(numberOfPeople, dayOfWeek);
                break;

        }

        return String.format(TOTAL_PRICE_FORMAT, price);

    }

    private static double getStudentsTotalPrice(int numberOfPeople, String dayOfWeek) {

        double price = 0.0;

        switch (dayOfWeek) {

            case FRIDAY:
                price = numberOfPeople * 8.45;
                break;

            case SATURDAY:
                price = numberOfPeople * 9.8;
                break;

            case SUNDAY:
                price = numberOfPeople * 10.46;
                break;

        }

        return numberOfPeople >= 30 ? price - price * 0.15
                : price;

    }

    private static double getBusinessTotalPrice(int numberOfPeople, String dayOfWeek) {

        double price = 0.0;

        switch (dayOfWeek) {

            case FRIDAY:
                price = numberOfPeople >= 100 ? (numberOfPeople - 10) * 10.9 : numberOfPeople * 10.9;
                break;

            case SATURDAY:
                price = numberOfPeople >= 100 ? (numberOfPeople - 10) * 15.6 : numberOfPeople * 15.6;
                break;

            case SUNDAY:
                price = numberOfPeople >= 100 ? (numberOfPeople - 10) * 16 : numberOfPeople * 16;
                break;

        }

        return price;

    }

    private static double getRegularTotalPrice(int numberOfPeople, String dayOfWeek) {

        double price = 0.0;

        switch (dayOfWeek) {

            case FRIDAY:
                price = numberOfPeople * 15;
                break;

            case SATURDAY:
                price = numberOfPeople * 20;
                break;

            case SUNDAY:
                price = numberOfPeople * 22.5;
                break;

        }

        return numberOfPeople >= 10 && numberOfPeople <= 20 ? price - price * 0.05
                : price;

    }
}