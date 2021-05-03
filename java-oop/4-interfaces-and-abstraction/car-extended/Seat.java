public class Seat extends CarImpl implements Sellable {

    private double price;

    public Seat(String model, String color, int horsePower, String countryProduced,
            double price) {
        super(model, color, horsePower, countryProduced);
        this.setPrice(price);
    }

    // Getters
    @Override
    public String getModel() {
        return super.getModel();
    }
    @Override
    public String getColor() {
        return super.getColor();
    }
    @Override
    public int getHorsePower() {
        return super.getHorsePower();
    }
    @Override
    public String countryProduced() {
        return super.countryProduced();
    }
    @Override
    public double getPrice() {
        return this.price;
    }

    // Setter
    private void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                String.format(SELLABLE_TO_STRING_TEMPLATE, this.getModel(),
                        String.format(DOUBLE_FORMAT_PATTERN, this.getPrice()));
    }
}
