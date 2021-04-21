import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Engine {

    private static final String FRAGILE_COMMAND = "fragile";
    private static final String FLAMABLE_COMMAND = "flamable";

    private List<Car> carsList;

    public Engine() {
        this.setCarsList(new LinkedList<>());
    }

    //Getter
    private List<Car> getCarsList() {
        return this.carsList;
    }

    // Setter
    private void setCarsList(List<Car> carsList) {
        this.carsList = carsList;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = readIntNumber(scanner);

        while (numberOfLines-- > 0) {
            String[] carInfo = readStringArray(scanner);

            String model = carInfo[0];
            int carEngineSpeed = Integer.parseInt(carInfo[1]);
            int carEnginePower = Integer.parseInt(carInfo[2]);
            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];

            double firstTirePressure = Double.parseDouble(carInfo[5]);
            int firstTireAge = Integer.parseInt(carInfo[6]);
            double secondTirePressure = Double.parseDouble(carInfo[7]);
            int secondTireAge = Integer.parseInt(carInfo[8]);
            double thirdTirePressure = Double.parseDouble(carInfo[9]);
            int thirdTireAge = Integer.parseInt(carInfo[10]);
            double fourthTirePressure = Double.parseDouble(carInfo[11]);
            int fourthTireAge = Integer.parseInt(carInfo[12]);

            CarEngine carEngine = new CarEngine(carEngineSpeed, carEnginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire firstTire = new Tire(firstTirePressure, firstTireAge);
            Tire secondTire = new Tire(secondTirePressure, secondTireAge);
            Tire thirdTire = new Tire(thirdTirePressure, thirdTireAge);
            Tire fourthTire = new Tire(fourthTirePressure, fourthTireAge);

            this.getCarsList().add(
                    new Car(model, carEngine, cargo, firstTire, secondTire, thirdTire, fourthTire));
        }

        String command = readStringLine(scanner);

        if (FRAGILE_COMMAND.equals(command)) {
            printFragileCargoTypeCars();
        } else if (FLAMABLE_COMMAND.equals(command)) {
            printFlamableCargoTypeCars();
        }
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

    // Cargo Type is "fragile" with a tire whose pressure is  < 1
    private void printFragileCargoTypeCars() {
        this.getCarsList()
                .stream()
                .filter(car ->
                        car.getCargoType().equals(FRAGILE_COMMAND) &&
                                car.getTirePressure() < 1)
                .forEach(System.out::println);
    }

    // Cargo Type is "flamable" and have Engine Power > 250.
    private void printFlamableCargoTypeCars() {
        this.getCarsList()
                .stream()
                .filter(car ->
                        car.getCargoType().equals(FLAMABLE_COMMAND) &&
                                car.getEnginePower() > 250)
                .forEach(System.out::println);
    }
}
