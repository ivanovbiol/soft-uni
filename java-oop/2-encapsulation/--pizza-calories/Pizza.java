package pizza;

import static pizza.Messages.*;
import static pizza.PizzaValidator.*;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    // Getters
    public String getName() {
        return this.name;
    }

    private Dough getDough() {
        return this.dough;
    }

    private List<Topping> getToppings() {
        return this.toppings;
    }

    // Setters
    public void setName(String name) {
        if (isInvalidPizzaName(name)) {
            throw new IllegalArgumentException(INVALID_PIZZA_NAME);
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        if (doughIsNotNull(dough)) {
            this.dough = dough;
        }
    }

    public void setToppings(int numberOfToppings) {
        if (isInvalidNumberOfToppings(numberOfToppings)) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_TOPPINGS);
        }
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public void addTopping(Topping topping) {
        if (topping != null) {
            this.getToppings().add(topping);
        }
    }

    public double getOverallCalories() {
        if (this.getDough() != null && !this.getToppings().isEmpty()) {
            return this.getDough().calculateCalories() +
                    this.getToppings()
                            .stream()
                            .mapToDouble(Topping::calculateCalories)
                            .sum();
        } else if (this.getDough() != null) {
            return this.getDough().calculateCalories();
        }
        return this.getToppings()
                .stream()
                .mapToDouble(Topping::calculateCalories)
                .sum();
    }
}
