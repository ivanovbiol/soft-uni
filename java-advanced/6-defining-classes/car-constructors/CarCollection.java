import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CarCollection {

    private List<Car> collection;

    public CarCollection() {
        this.setCollection(new LinkedList<>());
    }

    // Getter
    private List<Car> getCollection() {
        return this.collection;
    }

    // Setter
    private void setCollection(List<Car> collection) {
        this.collection = collection;
    }

    public void addCar(Car car) {
        this.getCollection().add(car);
    }

    @Override
    public String toString() {
        return this.getCollection()
                .stream()
                .map(Car::carInfo)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
