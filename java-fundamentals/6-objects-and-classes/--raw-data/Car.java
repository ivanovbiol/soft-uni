import java.util.List;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tire;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tireList) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tireList;
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    private List<Tire> getTire() {
        return this.tire;
    }

    public boolean isTirePressureBelowOne() {
        return this.getTire()
                .stream()
                .anyMatch(e -> e.getPressure() < 1);
    }
}
