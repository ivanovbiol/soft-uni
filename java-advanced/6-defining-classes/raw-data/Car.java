import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Car {

    private String model;
    private CarEngine carEngine;
    private Cargo cargo;
    private List<Tire> tiresList;

    private Car(String model, CarEngine carEngine, Cargo cargo) {
        this.setModel(model);
        this.setCarEngine(carEngine);
        this.setCargo(cargo);
        this.setTiresList(new LinkedList<>());
    }

    public Car(String model, CarEngine carEngine, Cargo cargo, Tire firstTire, Tire secondTire,
            Tire thirdTire, Tire fourthTire) {
        this(model, carEngine, cargo);
        this.getTiresList().add(firstTire);
        this.getTiresList().add(secondTire);
        this.getTiresList().add(thirdTire);
        this.getTiresList().add(fourthTire);
    }

    // Getters
    private String getModel() {
        return this.model;
    }
    private CarEngine getCarEngine() {
        return this.carEngine;
    }
    private Cargo getCargo() {
        return this.cargo;
    }
    private List<Tire> getTiresList() {
        return this.tiresList;
    }

    // Setters
    private void setModel(String model) {
        this.model = model;
    }
    private void setCarEngine(CarEngine carEngine) {
        this.carEngine = carEngine;
    }
    private void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    private void setTiresList(List<Tire> tiresList) {
        this.tiresList = tiresList;
    }

    public String getCargoType() {
        return this.getCargo().getCargoType();
    }

    public double getTirePressure() {
        return this.getTiresList()
                .stream()
                .mapToDouble(Tire::getPressure)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public int getEnginePower() {
        return this.getCarEngine().getEnginePower();
    }

    @Override
    public String toString() {
        return this.getModel();
    }
}
