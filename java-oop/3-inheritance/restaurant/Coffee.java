import java.math.BigDecimal;

public class Coffee extends HotBeverage {

    private static final double COFFEE_MILLILITERS = 50;
    private static final BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);

    private double caffeine;

    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        this.setCaffeine(caffeine);
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
    public double getCaffeine() {
        return this.caffeine;
    }

    // Setter
    private void setCaffeine(double caffeine) {
        this.caffeine = caffeine;
    }
}
