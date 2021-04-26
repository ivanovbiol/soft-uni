public enum SuitPower {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private final int suitPower;

    SuitPower(int power) {
        this.suitPower = power;
    }

    // Getter
    public int getPower() {
        return this.suitPower;
    }
}
