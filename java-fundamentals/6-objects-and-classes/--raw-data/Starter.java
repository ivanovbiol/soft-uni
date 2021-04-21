import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Starter {

    private static final String FRAGILE = "fragile";
    private static final String FLAMABLE = "flamable";

    public void start() {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = readIntNumber(scanner);

        processCommandsAndPrintResult(scanner, numberOfLines);
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void processCommandsAndPrintResult(Scanner scanner, int numberOfLines) {
        List<Car> carsList = new LinkedList<>();

        while (numberOfLines-- > 0) {
            String[] carData = readInputCarData(scanner);

            String model = carData[0];

            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);

            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];

            double firstTyrePressure = Double.parseDouble(carData[5]);
            int firstTyreAge = Integer.parseInt(carData[6]);
            double secondTyrePressure = Double.parseDouble(carData[7]);
            int secondTyreAge = Integer.parseInt(carData[8]);
            double thirdTyrePressure = Double.parseDouble(carData[9]);
            int thirdTyreAge = Integer.parseInt(carData[10]);
            double fourthTyrePressure = Double.parseDouble(carData[11]);
            int fourthTyreAge = Integer.parseInt(carData[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tiresList = new ArrayList<>();
            tiresList.add(new Tire(firstTyrePressure, firstTyreAge));
            tiresList.add(new Tire(secondTyrePressure, secondTyreAge));
            tiresList.add(new Tire(thirdTyrePressure, thirdTyreAge));
            tiresList.add(new Tire(fourthTyrePressure, fourthTyreAge));

            carsList.add(new Car(model, engine, cargo, tiresList));

        }

        printResult(scanner, carsList);
    }

    private static String[] readInputCarData(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static void printResult(Scanner scanner, List<Car> carsList) {
        String word = readStringInput(scanner);

        if (word.equals(FRAGILE)) {
            carsList
                    .stream()
                    .filter(e ->
                            e.getCargo().getCargoType().equals(FRAGILE) &&
                                    e.isTirePressureBelowOne())
                    .forEach(e -> System.out.println(e.getModel()));
        } else if (word.equals(FLAMABLE)) {
            carsList
                    .stream()
                    .filter(e ->
                            e.getCargo().getCargoType().equals(FLAMABLE) &&
                                    e.getEngine().getEnginePower() > 250)
                    .forEach(e -> System.out.println(e.getModel()));
        }
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
