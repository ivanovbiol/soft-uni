import java.math.BigDecimal;

public abstract class Product {

    private String name;
    private BigDecimal price;

    protected Product(String name, BigDecimal price) {
        this.setName(name);
        this.setPrice(price);
    }

    // Getters
    protected String getName() {
        return this.name;
    }
    protected BigDecimal getPrice() {
        return this.price;
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setPrice(BigDecimal price) {
        this.price = price;
    }
}
