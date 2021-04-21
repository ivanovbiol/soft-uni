public class Tire {
    private double pressure;
    private int age;

    public Tire(double pressure, int age) {
        this.setPressure(pressure);
        this.setAge(age);
    }

    // Getter
    public double getPressure() {
        return this.pressure;
    }

    // Setters
    private void setPressure(double pressure) {
        this.pressure = pressure;
    }
    private void setAge(int age) {
        this.age = age;
    }
}
