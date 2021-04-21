public class Car {

    private static final String SPACE_TEMPLATE = " ";

    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.setModel(model);
        this.setSpeed(speed);
    }

    //Getters
    private String getModel() {
        return this.model;
    }
    private int getSpeed() {
        return this.speed;
    }

    // Setters
    private void setModel(String model) {
        this.model = model;
    }
    private void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.getModel())
                .append(SPACE_TEMPLATE)
                .append(this.getSpeed())
                .append(System.lineSeparator())
                .toString();
    }
}
