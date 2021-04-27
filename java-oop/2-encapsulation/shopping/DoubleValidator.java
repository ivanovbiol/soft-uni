package shopping;

public class DoubleValidator {

    private DoubleValidator() {
    }

    public static boolean areNotValidMoney(double money) {
        return money < 0;
    }
}
