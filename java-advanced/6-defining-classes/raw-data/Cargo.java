public class Cargo {
    private int cargoWeight;
    private String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        this.setCargoWeight(cargoWeight);
        this.setCargoType(cargoType);
    }

    // Getter
    public String getCargoType() {
        return this.cargoType;
    }

    // Setters
    private void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }
    private void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
}
