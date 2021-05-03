import java.math.BigDecimal;

public abstract class Starter extends Food {

    public Starter(String name, BigDecimal price, double grams) {
        super(name, price, grams);
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
    protected double getGrams() {
        return super.getGrams();
    }
}
