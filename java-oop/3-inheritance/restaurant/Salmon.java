import java.math.BigDecimal;

public class Salmon extends MainDish {

    private static final double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }

    //Getters
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
