public abstract class Vehicle {

    protected static final String VEHICLE_TRAVELLED_PRINT_TEMPLATE = "%s travelled %s km";
    protected static final String VEHICLE_NEEDS_REFUELING_PRINT_TEMPLATE = "%s needs refueling";
    protected static final String REMAINING_FUEL_PRINT_TEMPLATE = "%s: %.2f";
    protected static final String DECIMAL_FORMATTER_TEMPLATE = "##.##";

    private double fuelQuantity;
    private double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    // Getters
    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }
    protected double getFuelConsumption() {
        return this.fuelConsumption;
    }

    // Setters
    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }
    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected abstract void drive(double km);

    protected abstract void refuel(double fuelAmount);

    @Override
    public String toString() {
        return null;
    }
}