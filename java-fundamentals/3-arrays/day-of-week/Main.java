import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] daysOfWeek = new String[] {"Invalid day!", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int number = readInputNumber();

        System.out.println(number < 1 || number > 7 ? daysOfWeek[0] : daysOfWeek[number]);

    }

    private static int readInputNumber() {

        return Integer.parseInt(new Scanner(System.in).nextLine());

    }
}