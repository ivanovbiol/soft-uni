import java.math.BigDecimal;

public class Soup extends Starter {

    public Soup(String name, BigDecimal price, double grams) {
        super(name, price, grams);
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
    public double getGrams() {
        return super.getGrams();
    }
}
