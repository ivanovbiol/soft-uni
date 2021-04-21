import java.util.Scanner;

public class Engine {
    private CarCollection carCollection;

    public Engine() {
        this.setCarCollection(new CarCollection());
    }

    // Getter
    private CarCollection getCarCollection() {
        return this.carCollection;
    }

    // Setter
    private void setCarCollection(CarCollection carCollection) {
        this.carCollection = carCollection;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = readIntNumber(scanner);

        while (numberOfLines-- > 0) {
            String[] carInfo = readStringArray(scanner);
            String brand;
            String model;
            int horsePower;

            if (carInfo.length == 1) {
                try {
                    horsePower = Integer.parseInt(carInfo[0]);
                    this.getCarCollection().addCar(new Car(horsePower));
                } catch (NumberFormatException numberFormatException) {
                    brand = carInfo[0];
                    this.getCarCollection().addCar(new Car(brand));
                }
            } else if (carInfo.length == 2) {
                brand = carInfo[0];

                try {
                    horsePower = Integer.parseInt(carInfo[1]);
                    this.getCarCollection().addCar(new Car(brand, horsePower));
                } catch (NumberFormatException numberFormatException) {
                    model = carInfo[1];
                    this.getCarCollection().addCar(new Car(brand, model));
                }
            } else {
                brand = carInfo[0];
                model = carInfo[1];
                horsePower = Integer.parseInt(carInfo[2]);
                this.getCarCollection().addCar(new Car(brand, model, horsePower));
            }
        }

        System.out.println(this.getCarCollection().toString());
    }

    private int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
