package pizza;

import static pizza.Constants.*;

public class DoughValidator {

    private DoughValidator() {
    }

    public static boolean isInvalidFlourType(String flourType) {
        return !ALLOWED_FLOUR_TYPES.contains(flourType);
    }

    public static boolean isInvalidBakingTechnique(String bakingTechnique) {
        return !ALLOWED_BAKING_TECHNIQUES.contains(bakingTechnique);
    }

    public static boolean isInvalidDoughWeight(double weight) {
        return weight < MIN_DOUGH_WEIGHT || weight > MAX_DOUGH_WEIGHT;
    }
}
