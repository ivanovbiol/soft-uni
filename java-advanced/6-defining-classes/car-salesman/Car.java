public class Car {

    private String model;
    private CarEngine carEngine;
    private int weight;
    private String color;

    public Car(String model, CarEngine carEngine) {
        this.setModel(model);
        this.setCarEngine(carEngine);
        this.setWeight(-1);
        this.setColor(Engine.NOT_ANNOTATED_MESSAGE);
    }

    public Car(String model, CarEngine carEngine, int weight) {
        this(model, carEngine);
        this.setWeight(weight);
    }

    public Car(String model, CarEngine carEngine, String color) {
        this(model, carEngine);
        this.setColor(color);
    }

    public Car(String model, CarEngine carEngine, int weight, String color) {
        this(model, carEngine, weight);
        this.setColor(color);
    }

    // Getters
    private String getModel() {
        return this.model;
    }
    private CarEngine getCarEngine() {
        return this.carEngine;
    }
    private int getWeight() {
        return this.weight;
    }
    private String getColor() {
        return this.color;
    }

    // Setters
    private void setModel(String model) {
        this.model = model;
    }
    private void setCarEngine(CarEngine carEngine) {
        this.carEngine = carEngine;
    }
    private void setWeight(int weight) {
        this.weight = weight;
    }
    private void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.getModel()).append(":").append(System.lineSeparator());
        stringBuilder.append(this.getCarEngine().toString()).append(System.lineSeparator());

        stringBuilder.append("Weight: ")
                .append(this.getWeight() < 0 ? Engine.NOT_ANNOTATED_MESSAGE : this.getWeight())
                .append(System.lineSeparator());

        stringBuilder.append("Color: ").append(this.getColor());

        return stringBuilder.toString();
    }
}
