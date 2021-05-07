package farm.animal;

import farm.food.Food;

public class Zebra extends Mammal {

    public Zebra(String name, String type, double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        super.makeSound();
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
