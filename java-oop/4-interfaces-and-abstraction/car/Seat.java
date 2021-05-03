public class Seat implements Car {

    private String model;
    private String color;
    private int horsePower;
    private String countryProduced;

    public Seat(String model, String color, int horsePower, String countryProduced) {
        this.setModel(model);
        this.setColor(color);
        this.setHorsePower(horsePower);
        this.setCountryProduced(countryProduced);
    }

    // Getters
    @Override
    public String getModel() {
        return this.model;
    }
    @Override
    public String getColor() {
        return this.color;
    }
    @Override
    public int getHorsePower() {
        return this.horsePower;
    }
    @Override
    public String countryProduced() {
        return this.countryProduced;
    }

    // Setters
    private void setModel(String model) {
        this.model = model;
    }
    private void setColor(String color) {
        this.color = color;
    }
    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    private void setCountryProduced(String countryProduced) {
        this.countryProduced = countryProduced;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE, this.getModel(), this.countryProduced(), TIRES);
    }
}
