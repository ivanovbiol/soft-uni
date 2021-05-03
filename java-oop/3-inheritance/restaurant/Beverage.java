import java.math.BigDecimal;

public abstract class Beverage extends Product {

    private double milliliters;

    protected Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.setMilliliters(milliliters);
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
    protected double getMilliliters() {
        return this.milliliters;
    }

    // Setter
    private void setMilliliters(double milliliters) {
        this.milliliters = milliliters;
    }
}
