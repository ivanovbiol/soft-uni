public abstract class Vehicle {

    private String type;
    private String model;
    private String color;
    private int horsePower;

    protected Vehicle(String type, String model, String color, int horsePower) {
        this.setType(type);
        this.setModel(model);
        this.setColor(color);
        this.setHorsePower(horsePower);
    }

    protected String getType() {
        return this.type;
    }

    protected String getModel() {
        return this.model;
    }

    private String getColor() {
        return this.color;
    }

    protected int getHorsePower() {
        return this.horsePower;
    }

    private void setType(String type) {
        this.type = type;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setColor(String color) {
        this.color = color;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("Type: ")
                .append(this.getType().substring(0, 1).toUpperCase())
                .append(this.getType().substring(1))
                .append(System.lineSeparator());
        stringBuilder
                .append("Model: ")
                .append(this.getModel())
                .append(System.lineSeparator());
        stringBuilder
                .append("Color: ")
                .append(this.getColor())
                .append(System.lineSeparator());
        stringBuilder.
                append("Horsepower: ")
                .append(this.getHorsePower());

        return stringBuilder.toString();
    }
}
