package pizza;

import static pizza.Constants.*;

public class PizzaValidator {

    private PizzaValidator() {
    }

    public static boolean isInvalidPizzaName(String name) {
        return name.trim().isEmpty() || name.length() > MAX_PIZZA_NAME_LENGTH;
    }

    public static boolean isInvalidNumberOfToppings(int numberOfToppings) {
        return numberOfToppings < MIN_TOPIC_COUNT || numberOfToppings > MAX_TOPIC_COUNT;
    }

    public static boolean doughIsNotNull(Dough dough) {
        return dough != null;
    }
}
