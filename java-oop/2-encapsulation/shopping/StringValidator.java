package shopping;

public class StringValidator {

    private StringValidator() {
    }

    public static boolean isNotValidName(String name) {
        return name == null || name.trim().isEmpty();
    }
}
