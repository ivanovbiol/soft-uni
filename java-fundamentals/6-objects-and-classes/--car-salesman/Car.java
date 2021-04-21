public class Car {

    private String model;
    private Engine engine;
    private int wight;
    private String color;

    public Car(String model, Engine engine) {
        this.setModel(model);
        this.setEngine(engine);
        this.setWight(0);
        this.setColor("n/a");
    }

    public Car(String model, Engine engine, int wight) {
        this(model, engine);
        this.wight = wight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int wight, String color) {
        this(model, engine, wight);
        this.color = color;
    }

    private String getModel() {
        return this.model;
    }

    private Engine getEngine() {
        return this.engine;
    }

    private int getWight() {
        return this.wight;
    }

    private String getColor() {
        return this.color;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setEngine(Engine engine) {
        this.engine = engine;
    }

    private void setWight(int wight) {
        this.wight = wight;
    }

    private void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(this.getModel()).append(":")
                .append(System.lineSeparator());
        stringBuilder
                .append(this.getEngine().toString())
                .append(System.lineSeparator());
        stringBuilder
                .append("  ").append("Weight: ")
                .append(this.getWight() == 0 ? "n/a" : this.getWight())
                .append(System.lineSeparator());
        stringBuilder
                .append("  ").append("Color: ").append(this.getColor());

        return stringBuilder.toString();
    }
}
