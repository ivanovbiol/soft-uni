package pizza;

import static pizza.Constants.ALLOWED_TOPPING_TYPES;

public class ToppingValidator {

    private ToppingValidator() {
    }

    public static boolean isInvalidToppingType(String toppingType) {
        return !ALLOWED_TOPPING_TYPES.contains(toppingType);
    }

    public static boolean isInvalidToppingWeight(double weight) {
        return weight < 1 || weight > 50;
    }
}
