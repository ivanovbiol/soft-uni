package pizza;

import static pizza.Constants.*;
import static pizza.Messages.*;
import static pizza.ToppingValidator.*;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    // Getters
    private String getToppingType() {
        return this.toppingType;
    }

    private double getWeight() {
        return this.weight;
    }

    // Setters
    private void setToppingType(String toppingType) {
        if (isInvalidToppingType(toppingType.toLowerCase())) {
            throw new IllegalArgumentException(
                    String.format(INVALID_TOPPING_TYPE_FORMAT, toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(isInvalidToppingWeight(weight)) {
            throw new IllegalArgumentException(
                    String.format(INVALID_TOPPING_WEIGHT_FORMAT, this.getToppingType()));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (BASE_CALORIES_PER_GRAM * this.getWeight()) *
                TOPPINGS_MODIFIERS.get(this.getToppingType());
    }
}
