public class Car extends Vehicle{

    public Car(String type, String model, String color, int horsePower) {
        super(type, model, color, horsePower);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public int getHorsePower() {
        return super.getHorsePower();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
