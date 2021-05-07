package farm.food;

public abstract class Food {

    private int quantity;

    protected Food(int quantity) {
        this.setQuantity(quantity);
    }

    // Getter
    public int getQuantity() {
        return this.quantity;
    }

    // Setter
    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
