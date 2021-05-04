import java.text.DecimalFormat;

public class Car extends Vehicle {

    private static final double INCREASEMENT_OF_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    // Getters
    @Override
    protected double getFuelQuantity() {
        return super.getFuelQuantity();
    }
    @Override
    protected double getFuelConsumption() {
        return super.getFuelConsumption();
    }

    //Setters
    @Override
    protected void setFuelQuantity(double fuelQuantity) {
        super.setFuelQuantity(fuelQuantity);
    }
    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption);
    }

    @Override
    public void drive(double km) {
        if (km * (this.getFuelConsumption() + INCREASEMENT_OF_FUEL_CONSUMPTION) <= this
                .getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - km * (this.getFuelConsumption()
                    + INCREASEMENT_OF_FUEL_CONSUMPTION));

            System.out.printf(VEHICLE_TRAVELLED_PRINT_TEMPLATE, this.getClass().getSimpleName(),
                    new DecimalFormat(DECIMAL_FORMATTER_TEMPLATE).format(km)).println();
        } else {
            System.out.printf(
                    VEHICLE_NEEDS_REFUELING_PRINT_TEMPLATE, this.getClass().getSimpleName())
                    .println();
        }
    }

    @Override
    public void refuel(double fuelAmount) {
        this.setFuelQuantity(this.getFuelQuantity() + fuelAmount);
    }

    @Override
    public String toString() {
        return String.format(REMAINING_FUEL_PRINT_TEMPLATE, this.getClass().getSimpleName(),
                this.getFuelQuantity());
    }
}
