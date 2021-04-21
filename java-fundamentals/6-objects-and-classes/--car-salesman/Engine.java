public class Engine {

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.setModel(model);
        this.setPower(power);
        this.setDisplacement(0);
        this.setEfficiency("n/a");
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power, displacement);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

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

        stringBuilder
                .append("  ").append(this.getModel()).append(":")
                .append(System.lineSeparator());
        stringBuilder
                .append("    ").append("Power: ").append(this.getPower())
                .append(System.lineSeparator());
        stringBuilder
                .append("    ").append("Displacement: ")
                .append(this.getDisplacement() == 0 ? "n/a" : this.getDisplacement())
                .append(System.lineSeparator());
        stringBuilder
                .append("    ").append("Efficiency: ").append(this.getEfficiency());

        return stringBuilder.toString();
    }
}
