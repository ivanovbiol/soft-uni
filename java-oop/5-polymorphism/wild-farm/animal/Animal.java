package farm.animal;

import static farm.messages.Constants.*;
import static farm.messages.Messages.*;

import farm.food.*;
import java.text.DecimalFormat;

public abstract class Animal {

    private String name;
    private String type;
    private double weight;
    private int foodEaten;

    protected Animal(String name, String type, double weight) {
        this.setName(name);
        this.setType(type);
        this.setWeight(weight);
    }

    // Getter
    protected String getName() {
        return this.name;
    }
    protected String getType() {
        return this.type;
    }
    protected double getWeight() {
        return this.weight;
    }
    protected int getFoodEaten() {
        return this.foodEaten;
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setType(String type) {
        this.type = type;
    }
    private void setWeight(double weight) {
        this.weight = weight;
    }
    private void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public void makeSound() {
        if (this instanceof Mouse) {
            System.out.println(MOUSE_SOUND);
        } else if (this instanceof Zebra) {
            System.out.println(ZEBRA_SOUND);
        } else if (this instanceof Cat) {
            System.out.println(CAT_SOUND);
        } else if (this instanceof Tiger) {
            System.out.println(TIGER_SOUND);
        }
    }

    public void eat(Food food) {
        if (this instanceof Mouse) {
            if (food instanceof Meat) {
                throw new IllegalArgumentException(MICE_ARE_NOT_EATING_THAT_FOOD_TEMPLATE);
            } else {
                this.setFoodEaten(food.getQuantity());
            }
        } else if (this instanceof Zebra) {
            if (food instanceof Meat) {
                throw new IllegalArgumentException(ZEBRAS_ARE_NOT_EATING_THAT_FOOD_TEMPLATE);
            } else {
                this.setFoodEaten(food.getQuantity());
            }
        }else if (this instanceof Tiger) {
            if (food instanceof Vegetable) {
                throw new IllegalArgumentException(TIGERS_ARE_NOT_EATING_THAT_FOOD_TEMPLATE);
            } else {
                this.setFoodEaten(food.getQuantity());
            }
        } else {
            this.setFoodEaten(food.getQuantity());
        }
    }

    @Override
    public abstract String toString();
}
