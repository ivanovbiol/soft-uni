public class CarEngine {

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public CarEngine(String model, int power) {
        this.setModel(model);
        this.setPower(power);
        this.setDisplacement(-1);
        this.setEfficiency(Engine.NOT_ANNOTATED_MESSAGE);
    }

    public CarEngine(String model, int power, int displacement) {
        this(model, power);
        this.setDisplacement(displacement);
    }

    public CarEngine(String model, int power, String efficiency) {
        this(model, power);
        this.setEfficiency(efficiency);
    }

    public CarEngine(String model, int power, int displacement, String efficiency) {
        this(model, power, displacement);
        this.setEfficiency(efficiency);
    }

    // Getters
    private String getModel() {
        return this.model;
    }
    private int getPower() {
        return this.power;
    }
    private int getDisplacement() {
        return this.displacement;
    }
    private String getEfficiency() {
        return this.efficiency;
    }

    // Setters
    private void setModel(String model) {
        this.model = model;
    }
    private void setPower(int power) {
        this.power = power;
    }
    private void setDisplacement(int displacement) {
        this.displacement = displacement;
    }
    private void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.getModel()).append(":").append(System.lineSeparator());
        stringBuilder.append("Power: ").append(this.getPower()).append(System.lineSeparator());

        stringBuilder.append("Displacement: ")
                .append(this.getDisplacement() < 0 ? Engine.NOT_ANNOTATED_MESSAGE
                        : this.getDisplacement())
                .append(System.lineSeparator());

        stringBuilder.append("Efficiency: ").append(this.getEfficiency());

        return stringBuilder.toString();
    }
}
