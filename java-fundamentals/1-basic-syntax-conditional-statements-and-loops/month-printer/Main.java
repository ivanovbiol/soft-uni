import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String ERROR_MESSAGE = "Error!";
    private static final Map<Integer, String> months = new LinkedHashMap<>();

    public static void main(String[] args) {

        addMonthsInStaticMap();

        int number = readInputNumber();

        System.out.println(findResult(number));

    }

    private static void addMonthsInStaticMap() {

        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");

    }

    private static int readInputNumber() {

        return Integer.parseInt(new Scanner(System.in).nextLine());

    }

    private static String findResult(int number) {

        return number > 0 && number <= 12 ? months.get(number) : ERROR_MESSAGE;

    }
}
