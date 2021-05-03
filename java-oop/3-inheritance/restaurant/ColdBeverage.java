import java.math.BigDecimal;

public class ColdBeverage extends Beverage {

    protected ColdBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }

    // Getters
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public BigDecimal getPrice() {
        return super.getPrice();
    }
    @Override
    public double getMilliliters() {
        return super.getMilliliters();
    }
}
