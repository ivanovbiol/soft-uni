import java.util.Scanner;

public class Main {

    private static final String ERROR_MESSAGE = "Incorrect password. Try again.";
    private static final String LOGIN_MESSAGE_WITH_USERNAME = "User %s logged in.";
    private static final String BLOCKED_USERNAME = "User %s blocked!";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // When we have several lines of input we need to add the Scanner as parameter
        // otherwise each method won't read the new lines of input
        String username = readInputString(scanner);
        String password = readInputString(scanner);

        String realPassword = new StringBuffer(username).reverse().toString();

        int counter = 1;

        boolean loggedUser = password.equals(realPassword);

        while (!password.equals(realPassword)) {

            System.out.println(ERROR_MESSAGE);

            password = readInputString(scanner);

            counter++;

            loggedUser = password.equals(realPassword);

            if (counter == 4) {
                break;
            }

        }

        System.out.println(
                loggedUser ?
                        String.format(LOGIN_MESSAGE_WITH_USERNAME, username) :
                        String.format(BLOCKED_USERNAME, username));

    }

    private static String readInputString(Scanner scanner) {

        return scanner.nextLine();

    }
}