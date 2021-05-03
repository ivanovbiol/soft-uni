import java.math.BigDecimal;

public class Tea extends HotBeverage {

    public Tea(String name, BigDecimal price, double milliliters) {
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
