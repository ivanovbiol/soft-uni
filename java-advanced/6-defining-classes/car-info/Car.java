public class Car {

    private static final String PRINT_TEMPLATE = "The car is: %s %s - %d HP.";

    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand, String model, int horsePower) {
        this.setBrand(brand);
        this.setModel(model);
        this.setHorsePower(horsePower);
    }

    //Getters
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
