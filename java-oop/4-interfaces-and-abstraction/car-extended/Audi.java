public class Audi extends CarImpl implements Rentable {

    private int minRentPerDay;
    private double pricePerDay;

    public Audi(String model, String color, int horsePower, String countryProduced,
            int minRentPerDay, double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.setMinRentPerDay(minRentPerDay);
        this.setPricePerDay(pricePerDay);
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
    public int getMinRentDay() {
        return this.minRentPerDay;
    }
    @Override
    public double getPricePerDay() {
        return this.pricePerDay;
    }

    // Setters
    private void setMinRentPerDay(int minRentPerDay) {
        this.minRentPerDay = minRentPerDay;
    }
    private void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                String.format(RENTABLE_TO_STRING_TEMPLATE, this.getMinRentDay(),
                        String.format(DOUBLE_FORMAT_PATTERN, this.getPricePerDay()));
    }
}
