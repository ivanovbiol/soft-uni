package shopping;

import static shopping.Messages.*;

public class Product {

    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    // Setters
    private void setName(String name) {
        if (StringValidator.isNotValidName(name)) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
        this.name = name;
    }

    private void setCost(double cost) {
        if (DoubleValidator.areNotValidMoney(cost)) {
            throw new IllegalArgumentException(INVALID_MONEY_MESSAGE);
        }
        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
