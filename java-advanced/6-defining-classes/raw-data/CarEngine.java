public class CarEngine {

    private int engineSpeed;
    private int enginePower;

    public CarEngine(int engineSpeed, int enginePower) {
        this.setEnginePower(enginePower);
        this.setEngineSpeed(engineSpeed);
    }

    // Getter
    public int getEnginePower() {
        return enginePower;
    }

    // Setters
    private void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }
    private void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }
}
