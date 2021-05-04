import java.util.Scanner;

public class Engine {

    private static final String SPLIT_DELIMITER = "\\s+";
    private static final String DRIVE_COMMAND = "Drive";
    private static final String REFUEL_COMMAND = "Refuel";
    private static final String CAR_TYPE = "Car";
    private static final String TRUCK_TYPE = "Truck";

    public void run() {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = readStringArray(scanner);
        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));

        String[] truckInfo = readStringArray(scanner);
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int numberOfCommands = readIntNumber(scanner);

        while (numberOfCommands-- > 0) {
            String[] commandsArray = readStringArray(scanner);

            String command = commandsArray[0];
            String vehicleType = commandsArray[1];

            switch (command) {
                case DRIVE_COMMAND:
                    double kilometers = Double.parseDouble(commandsArray[2]);
                    driveVehicle(vehicleType, kilometers, car, truck);
                    break;
                case REFUEL_COMMAND:
                    double fuelAmount = Double.parseDouble(commandsArray[2]);
                    refuelVehicle(vehicleType, fuelAmount, car, truck);
                    break;
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split(SPLIT_DELIMITER);
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private void driveVehicle(String vehicleType, double kilometers, Vehicle car, Vehicle truck) {
        switch (vehicleType) {
            case CAR_TYPE:
                car.drive(kilometers);
                break;
            case TRUCK_TYPE:
                truck.drive(kilometers);
                break;
        }
    }

    private void refuelVehicle(String vehicleType, double fuelAmount, Vehicle car, Vehicle truck) {
        switch (vehicleType) {
            case CAR_TYPE:
                car.refuel(fuelAmount);
                break;
            case TRUCK_TYPE:
                truck.refuel(fuelAmount);
                break;
        }
    }
}
