import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Engine {

    public static final String NOT_ANNOTATED_MESSAGE = "n/a";

    private Map<String, CarEngine> carEnginesMap;
    private List<Car> carsList;

    public Engine() {
        this.setCarEnginesMap(new HashMap<>());
        this.setCarsList(new LinkedList<>());
    }

    // Getters
    private Map<String, CarEngine> getCarEnginesMap() {
        return this.carEnginesMap;
    }
    private List<Car> getCarsList() {
        return this.carsList;
    }

    // Setters
    private void setCarEnginesMap(Map<String, CarEngine> carEnginesMap) {
        this.carEnginesMap = carEnginesMap;
    }
    private void setCarsList(List<Car> carsList) {
        this.carsList = carsList;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int numberOfEngines = readIntNumber(scanner);

        while (numberOfEngines-- > 0) {
            String[] carEngineInfo = readStringArray(scanner);

            String engineModel = carEngineInfo[0];
            int enginePower = Integer.parseInt(carEngineInfo[1]);
            int engineDisplacement;
            String engineEfficiency;

            if (carEngineInfo.length == 2) {
                this.getCarEnginesMap().put(engineModel, new CarEngine(engineModel, enginePower));
            } else if (carEngineInfo.length == 3) {
                try {
                    engineDisplacement = Integer.parseInt(carEngineInfo[2]);
                    this.getCarEnginesMap().put(engineModel,
                            new CarEngine(engineModel, enginePower, engineDisplacement));
                } catch (NumberFormatException numberFormatException) {
                    engineEfficiency = carEngineInfo[2];
                    this.getCarEnginesMap().put(engineModel,
                            new CarEngine(engineModel, enginePower, engineEfficiency));
                }
            } else {
                engineDisplacement = Integer.parseInt(carEngineInfo[2]);
                engineEfficiency = carEngineInfo[3];

                this.getCarEnginesMap().put(engineModel,
                        new CarEngine(engineModel, enginePower, engineDisplacement,
                                engineEfficiency));
            }
        }

        int numberOfCars = readIntNumber(scanner);

        while (numberOfCars-- > 0) {
            String[] carInfo = readStringArray(scanner);

            String carModel = carInfo[0];
            String carEngineAsString = carInfo[1];
            int carWeight;
            String carColor;

            if (carInfo.length == 2) {
                this.getCarsList().add(new Car(carModel, this.getCarEnginesMap().get(carEngineAsString)));
            } else if (carInfo.length == 3) {
                try {
                    carWeight = Integer.parseInt(carInfo[2]);
                    this.getCarsList().add(
                            new Car(carModel, this.getCarEnginesMap().get(carEngineAsString), carWeight));
                } catch (NumberFormatException numberFormatException) {
                    carColor = carInfo[2];
                    this.getCarsList().add(new Car(carModel, this.getCarEnginesMap().get(carEngineAsString), carColor));
                }
            } else {
                carWeight = Integer.parseInt(carInfo[2]);
                carColor = carInfo[3];
                this.getCarsList().add(new Car(carModel, this.getCarEnginesMap().get(carEngineAsString), carWeight,
                        carColor));
            }
        }

        printCars();
    }

    private int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private void printCars() {
        this.getCarsList()
                .forEach(System.out::println);
    }
}
