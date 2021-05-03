import java.math.BigDecimal;

public abstract class Food extends Product {

    private double grams;

    protected Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.setGrams(grams);
    }

    // Getters
    @Override
    protected String getName() {
        return super.getName();
    }
    @Override
    protected BigDecimal getPrice() {
        return super.getPrice();
    }
    protected double getGrams() {
        return this.grams;
    }

    // Setter
    private void setGrams(double grams) {
        this.grams = grams;
    }
}
