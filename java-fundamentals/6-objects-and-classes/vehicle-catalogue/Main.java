import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String END_COMMAND = "End";
    private static final String CLOSE_THE_CATALOGUE_COMMAND = "Close the Catalogue";
    private static final String CARS_AVERAGE_HORSEPOWER_TEMPLATE = "Cars have average horsepower of: %.2f.";
    private static final String TRUCKS_AVERAGE_HORSEPOWER_TEMPLATE = "Trucks have average horsepower of: %.2f.";
    private static final String TRUCK_MODEL = "truck";
    private static final String CAR_MODEL = "car";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehiclesCatalogue = readVehiclesCatalogue(scanner);

        readModelsAndPrintVehiclesData(scanner, vehiclesCatalogue);
    }

    private static List<Vehicle> readVehiclesCatalogue(Scanner scanner) {
        List<Vehicle> vehiclesCatalogue = new ArrayList<>();

        String nextLine = readSingleLineStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            String[] vehicleData = nextLine.split("\\s+");

            String type = vehicleData[0];
            String model = vehicleData[1];
            String color = vehicleData[2];
            int horsePower = Integer.parseInt(vehicleData[3]);

            if (type.equals(CAR_MODEL)) {
                vehiclesCatalogue.add(new Car(type, model, color, horsePower));
            } else {
                vehiclesCatalogue.add(new Truck(type, model, color, horsePower));
            }

            nextLine = readSingleLineStringInput(scanner);
        }

        return vehiclesCatalogue;
    }

    private static String readSingleLineStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void readModelsAndPrintVehiclesData(Scanner scanner,
            List<Vehicle> vehiclesCatalogue) {
        String nextLine = readSingleLineStringInput(scanner);

        while (!CLOSE_THE_CATALOGUE_COMMAND.equals(nextLine)) {
            String model = nextLine;

            vehiclesCatalogue
                    .stream()
                    .filter(e -> e.getModel().equalsIgnoreCase(model))
                    .map(Vehicle::toString)
                    .forEach(System.out::println);

            nextLine = readSingleLineStringInput(scanner);
        }

        printAverageHorsePowerForVehicles(vehiclesCatalogue);
    }

    private static void printAverageHorsePowerForVehicles(List<Vehicle> vehiclesCatalogue) {

        double totalCarHorsePower =
                vehiclesCatalogue
                        .stream()
                        .filter(e -> e.getType().equalsIgnoreCase(CAR_MODEL))
                        .mapToInt(Vehicle::getHorsePower)
                        .sum();

        double totalTruckHorsePower =
                vehiclesCatalogue
                        .stream()
                        .filter(e -> e.getType().equalsIgnoreCase(TRUCK_MODEL))
                        .mapToInt(Vehicle::getHorsePower)
                        .sum();

        int carNumber =
                (int) vehiclesCatalogue
                        .stream()
                        .filter(e -> e.getType().equalsIgnoreCase(CAR_MODEL))
                        .count();

        int truckNumber =
                (int) vehiclesCatalogue
                        .stream()
                        .filter(e -> e.getType().equalsIgnoreCase(TRUCK_MODEL))
                        .count();

        System.out.printf(
                CARS_AVERAGE_HORSEPOWER_TEMPLATE,
                totalCarHorsePower / carNumber)
                .println();

        System.out.printf(
                TRUCKS_AVERAGE_HORSEPOWER_TEMPLATE,
                totalTruckHorsePower / truckNumber)
                .println();
    }
}
