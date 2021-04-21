public class Car {

    private static final String INSUFFICIENT_FUEL_MESSAGE = "Insufficient fuel for the drive";
    private static final String TO_STRING_TEMPLATE = "%s %.2f %d";

    private String model;
    private double fuelAmount;
    private double fuelCostPerOneKm;
    private int distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCostPerOneKm) {
        this.setModel(model);
        this.setFuelAmount(fuelAmount);
        this.setFuelCostPerOneKm(fuelCostPerOneKm);
        this.setDistanceTravelled(0);
    }

    // Getters
    private String getModel() {
        return this.model;
    }
    private double getFuelAmount() {
        return this.fuelAmount;
    }
    private double getFuelCostPerOneKm() {
        return this.fuelCostPerOneKm;
    }
    private int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    // Setters
    private void setModel(String model) {
        this.model = model;
    }
    private void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
    private void setFuelCostPerOneKm(double fuelCostPerOneKm) {
        this.fuelCostPerOneKm = fuelCostPerOneKm;
    }
    private void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public void drive(int km) {
        if (km * this.getFuelCostPerOneKm() <= this.getFuelAmount()) {
            this.setDistanceTravelled(this.getDistanceTravelled() + km);
            this.setFuelAmount(this.getFuelAmount() - (km * this.getFuelCostPerOneKm()));
        } else {
            System.out.println(INSUFFICIENT_FUEL_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE, this.getModel(), this.getFuelAmount(),
                this.getDistanceTravelled());
    }
}
