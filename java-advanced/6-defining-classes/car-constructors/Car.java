public class Car {

    private static final String PRINT_TEMPLATE = "The car is: %s %s - %d HP.";
    private static final String UNKNOWN_STRING_TEMPLATE = "unknown";
    private static final int NEGATIVE_HORSEPOWER_TEMPLATE = -1;

    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand) {
        this.setBrand(brand);
        this.setModel(UNKNOWN_STRING_TEMPLATE);
        this.setHorsePower(NEGATIVE_HORSEPOWER_TEMPLATE);
    }

    public Car(String brand, String model) {
        this(brand);
        this.setModel(model);
    }

    public Car(String brand, int horsePower) {
        this(brand);
        this.setHorsePower(horsePower);
    }

    public Car(int horsePower) {
        this(UNKNOWN_STRING_TEMPLATE);
        this.setModel(UNKNOWN_STRING_TEMPLATE);
        this.setHorsePower(horsePower);
    }

    public Car(String brand, String model, int horsePower) {
        this(brand, model);
        this.setHorsePower(horsePower);
    }

    // Getters
    private String getBrand() {
        return this.brand;
    }
    private String getModel() {
        return this.model;
    }
    private int getHorsePower() {
        return this.horsePower;
    }

    // Setters
    private void setBrand(String brand) {
        this.brand = brand;
    }
    private void setModel(String model) {
        this.model = model;
    }
    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String carInfo() {
        return String
                .format(PRINT_TEMPLATE, this.getBrand(), this.getModel(), this.getHorsePower());
    }
}
