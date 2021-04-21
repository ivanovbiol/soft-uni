import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // When we have several lines of input we need to add the Scanner as parameter
        // otherwise each method won't read the new lines of input
        int hour = readInputHourOrMinutes(scanner);
        int minutes = readInputHourOrMinutes(scanner);

        System.out.println(findResult(hour, minutes));

    }

    private static int readInputHourOrMinutes(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static String findResult(int hour, int minutes) {

        minutes += 30;

        if (minutes >= 60) {

            minutes -= 60;
            hour++;

            if (hour >= 24) {

                hour -= 24;

            }
        }

        return minutes > 9 ? String.format("%d:%d", hour, minutes)
                : String.format("%d:0%d", hour, minutes);

    }
}
