import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Starter {

    private static final Map<String, Engine> enginesMap = new HashMap<>();
    private static final List<Car> carsList = new LinkedList<>();

    public void start() {
        processCommandsAndPrintResult();
    }

    private static void processCommandsAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int numberOfEngines = readIntNumber(scanner);

        while (numberOfEngines-- > 0) {
            String[] engineData = readStringLineAsStringArray(scanner);

            String engineModel = engineData[0];
            int enginePower = Integer.parseInt(engineData[1]);
            int engineDisplacement = 0;
            String engineEfficiency = "";

            Engine engine = null;

            if (engineData.length == 2) {
                engine = new Engine(engineModel, enginePower);
            } else if (engineData.length == 3) {

                try {
                    engineDisplacement = Integer.parseInt(engineData[2]);

                    engine = new Engine(engineModel, enginePower, engineDisplacement);
                } catch (NumberFormatException numberFormatException) {
                    engineEfficiency = engineData[2];

                    engine = new Engine(engineModel, enginePower, engineEfficiency);
                }

            } else {
                engineDisplacement = Integer.parseInt(engineData[2]);
                engineEfficiency = engineData[3];

                engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            }

            enginesMap.putIfAbsent(engineModel, engine);
        }

        int numberOfCars = readIntNumber(scanner);

        while (numberOfCars-- > 0) {
            String[] carData = readStringLineAsStringArray(scanner);

            String carModel = carData[0];
            String engineModel = carData[1];
            int carWeight = 0;
            String carColor = "";

            Car car = null;

            if (carData.length == 2) {
                car = new Car(carModel, enginesMap.get(engineModel));
            } else if (carData.length == 3) {

                try {

                    carWeight = Integer.parseInt(carData[2]);
                    car = new Car(carModel, enginesMap.get(engineModel), carWeight);

                } catch (NumberFormatException numberFormatException) {

                    carColor = carData[2];
                    car = new Car(carModel, enginesMap.get(engineModel), carColor);

                }

            } else {
                carWeight = Integer.parseInt(carData[2]);
                carColor = carData[3];

                car = new Car(carModel, enginesMap.get(engineModel), carWeight, carColor);
            }

            carsList.add(car);
        }

        carsList
                .forEach(e -> System.out.println(e.toString()));

    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }


    private static String[] readStringLineAsStringArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
