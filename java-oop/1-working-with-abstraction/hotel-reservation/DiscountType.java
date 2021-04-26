public enum DiscountType {

    VIP(0.8),
    SECONDVISIT(0.9),
    NONE(1);

    private final double value;

    DiscountType(double value) {
        this.value = value;
    }

    // Getter
    public double getValue() {
        return this.value;
    }
}
