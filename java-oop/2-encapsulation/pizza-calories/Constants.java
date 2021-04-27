package pizza;

import java.util.Map;
import java.util.Set;

public class Constants {

    private Constants() {
    }

    public static final Set<String> ALLOWED_FLOUR_TYPES = Set.of("white", "wholegrain");

    public static final Set<String> ALLOWED_BAKING_TECHNIQUES = Set
            .of("crispy", "chewy", "homemade");

    public static final Map<String, Double> DOUGH_BAKING_TECHNIQUE_MODIFIERS = Map.of(
            "Crispy", 0.9,
            "Chewy", 1.1,
            "Homemade", 1.0);

    public static final Map<String, Double> DOUGH_FLOUR_TYPE_MODIFIERS = Map.of(
            "White", 1.5,
            "Wholegrain", 1.0);

    public static final Set<String> ALLOWED_TOPPING_TYPES = Set.of(
            "meat", "veggies", "cheese", "sauce");

    public static final Map<String, Double> TOPPINGS_MODIFIERS = Map.of(
            "Meat", 1.2,
            "Veggies", 0.8,
            "Cheese", 1.1,
            "Sauce", 0.9);

    public static final int BASE_CALORIES_PER_GRAM = 2;

    public static final int MAX_PIZZA_NAME_LENGTH = 15;

    public static final int MIN_TOPIC_COUNT = 0;

    public static final int MAX_TOPIC_COUNT = 10;

    public static final int MIN_DOUGH_WEIGHT = 1;

    public static final int MAX_DOUGH_WEIGHT = 200;

    public static final String SPLIT_DELIMITER = "\\s+";

    public static final boolean TRUE = true;

    public static final boolean FALSE = false;
}
