import java.math.BigDecimal;

public abstract class Dessert extends Food {

    private double calories;

    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.setCalories(calories);
    }

    //Getters
    @Override
    protected String getName() {
        return super.getName();
    }
    @Override
    protected BigDecimal getPrice() {
        return super.getPrice();
    }
    @Override
    protected double getGrams() {
        return super.getGrams();
    }
    protected double getCalories() {
        return this.calories;
    }

    // Setter
    private void setCalories(double calories) {
        this.calories = calories;
    }
}
