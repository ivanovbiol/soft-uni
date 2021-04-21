import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Engine {

    private static final String END_COMMAND = "End";

    private Map<String, Car> carsMap;

    public Engine() {
        this.setCarsMap(new LinkedHashMap<>());
    }

    // Getter
    private Map<String, Car> getCarsMap() {
        return this.carsMap;
    }

    // Setter
    private void setCarsMap(Map<String, Car> carsMap) {
        this.carsMap = carsMap;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = readIntNumber(scanner);
        String model;
        int amountOfKm;

        while (numberOfCars-- > 0) {
            String[] carData = readStringArray(scanner);

            model = carData[0];
            int fuelAmount = Integer.parseInt(carData[1]);
            double fuelConsumptionPerKm = Double.parseDouble(carData[2]);

            this.getCarsMap().put(model, new Car(model, fuelAmount, fuelConsumptionPerKm));
        }

        String nextLine = readStringLine(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            model = nextLine.split("\\s+")[1];
            amountOfKm = Integer.parseInt(nextLine.split("\\s+")[2]);

            this.getCarsMap().get(model).drive(amountOfKm);

            nextLine = readStringLine(scanner);
        }

        printCars();
    }

    private int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private void printCars() {
        carsMap
                .values()
                .forEach(System.out::println);
    }
}
