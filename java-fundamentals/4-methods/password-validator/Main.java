import java.util.Scanner;

public class Main {

    private static final String VALID_PASSWORD_MESSAGE = "Password is valid";
    private static final String INVALID_PASSWORD_LENGTH = "Password must be between 6 and 10 characters";
    private static final String INVALID_PASSWORD_LETTERS_AND_DIGITS = "Password must consist only of letters and digits";
    private static final String INVALID_PASSWORD_AT_LEAST_TWO_DIGITS = "Password must have at least 2 digits";

    public static void main(String[] args) {

        String password = readInputPassword();

        checkPassword(password);

    }

    private static String readInputPassword() {

        return new Scanner(System.in).nextLine();

    }

    private static void checkPassword(String password) {

        boolean isValid = true;

        if (isNotValidLength(password)) {
            isValid = false;
            System.out.println(INVALID_PASSWORD_LENGTH);
        }

        if (doesNotConsistsOnlyLettersAndDigits(password)) {
            isValid = false;
            System.out.println(INVALID_PASSWORD_LETTERS_AND_DIGITS);
        }

        if (doesNotHaveAtLeastTwoDigits(password)) {
            isValid = false;
            System.out.println(INVALID_PASSWORD_AT_LEAST_TWO_DIGITS);
        }

        if (isValid) {
            System.out.println(VALID_PASSWORD_MESSAGE);
        }

    }

    private static boolean isNotValidLength(String password) {

        return password.length() < 6 || password.length() > 10;

    }

    private static boolean doesNotConsistsOnlyLettersAndDigits(String password) {

        for (int i = 0; i < password.length(); i++) {

            if (!Character.isAlphabetic(password.charAt(i)) && !Character
                    .isDigit(password.charAt(i))) {
                return true;
            }

        }

        return false;

    }

    private static boolean doesNotHaveAtLeastTwoDigits(String password) {

        return password
                .chars()
                .map(e -> (char) e)
                .filter(Character::isDigit)
                .count() < 2;

    }
}