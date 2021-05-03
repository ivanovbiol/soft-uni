import java.math.BigDecimal;

public abstract class HotBeverage extends Beverage {

    protected HotBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
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
    @Override
    protected double getMilliliters() {
        return super.getMilliliters();
    }
}
