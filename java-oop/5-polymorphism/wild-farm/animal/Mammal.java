package farm.animal;

import static farm.messages.Messages.*;

import farm.food.Food;
import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    protected Mammal(String name, String type, double weight, String livingRegion) {
        super(name, type, weight);
        this.setLivingRegion(livingRegion);
    }

    // Getter
    protected String getLivingRegion() {
        return this.livingRegion;
    }

    // Setter
    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
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
      if (!(this instanceof Cat)) {
            return String.format(ANIMALS_PRINT_TEMPLATE,
                    this.getType(), this.getName(),
                    new DecimalFormat(DECIMAL_FORMAT_TEMPLATE).format(this.getWeight()),
                    this.getLivingRegion(), this.getFoodEaten());
        }
        throw new IllegalArgumentException();
    }
}
