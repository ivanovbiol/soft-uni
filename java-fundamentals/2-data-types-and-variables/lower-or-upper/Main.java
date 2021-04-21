import java.util.Scanner;

public class Main {

    private static final String LOWER_CASE = "lower-case";
    private static final String UPPER_CASE = "upper-case";

    public static void main(String[] args) {

        System.out.println(
                Character
                        .isLowerCase(new Scanner(System.in).nextLine().charAt(0)) ?
                        LOWER_CASE : UPPER_CASE);

    }
}