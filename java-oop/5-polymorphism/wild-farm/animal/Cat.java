package farm.animal;

import static farm.messages.Messages.*;

import farm.food.Food;
import java.text.DecimalFormat;

public class Cat extends Felime {

    private String breed;

    public Cat(String name, String type, double weight, String livingRegion, String breed) {
        super(name, type, weight, livingRegion);
        this.setBreed(breed);
    }

    // Getter
    private String getBreed() {
        return this.breed;
    }

    // Setter
    public void setBreed(String breed) {
        this.breed = breed;
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
    //{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]
            return String.format(CATS_PRINT_TEMPLATE,
            this.getType(), this.getName(), this.getBreed(),
                    new DecimalFormat(DECIMAL_FORMAT_TEMPLATE).format(this.getWeight()),
            this.getLivingRegion(), this.getFoodEaten());
    }
}
