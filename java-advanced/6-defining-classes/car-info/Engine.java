import java.util.Scanner;

public class Engine {

    public Engine() {
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = readIntNumber(scanner);

        while (numberOfLines-- > 0) {
            String[] carInfo = readStringArray(scanner);

            String brand = carInfo[0];
            String model = carInfo[1];
            int horsePower = Integer.parseInt(carInfo[2]);

            Car car = new Car(brand, model, horsePower);

            System.out.println(car.carInfo());
        }
    }

    private int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
