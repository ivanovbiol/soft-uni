package pizza;

import static pizza.Constants.*;
import static pizza.Messages.*;
import static pizza.DoughValidator.*;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    // Getters
    private String getFlourType() {
        return this.flourType;
    }

    private String getBakingTechnique() {
        return this.bakingTechnique;
    }

    private double getWeight() {
        return this.weight;
    }

    // Setters
    private void setFlourType(String flourType) {
        if (isInvalidFlourType(flourType.toLowerCase())) {
            throw new IllegalArgumentException(INVALID_DOUGH_TYPE);
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (isInvalidBakingTechnique(bakingTechnique.toLowerCase())) {
            throw new IllegalArgumentException(INVALID_DOUGH_TYPE);
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (isInvalidDoughWeight(weight)) {
            throw new IllegalArgumentException(INVALID_DOUGH_WEIGHT);
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (BASE_CALORIES_PER_GRAM * this.getWeight()) *
                DOUGH_BAKING_TECHNIQUE_MODIFIERS.get(this.getBakingTechnique()) *
                DOUGH_FLOUR_TYPE_MODIFIERS.get(this.getFlourType());
    }
}
