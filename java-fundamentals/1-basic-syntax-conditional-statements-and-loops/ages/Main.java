import java.util.Scanner;

public class Main {

    private static final String BABY = "baby";
    private static final String CHILD = "child";
    private static final String TEENAGER = "teenager";
    private static final String ADULT = "adult";
    private static final String ELDER = "elder";

    public static void main(String[] args) {

        int age = readInputAge();

        System.out.println(getResult(age));

    }

    private static int readInputAge() {

        return Integer.parseInt(new Scanner(System.in).nextLine());

    }

    private static String getResult(int age) {

        if (age >= 0 && age <= 2) {
            return BABY;
        } else if (age <= 13) {
            return CHILD;
        } else if (age <= 19) {
            return TEENAGER;
        } else if (age <= 65) {
            return ADULT;
        } else {
            return ELDER;
        }

    }
}