public class Engine {

    private static final String PRINT_TEMPLATE = "%s is %s color and have %s horse power";

    public Engine() {
    }

    public void run() {
        Car seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Car audi = new Audi("A4", "Gray", 110, "Germany", 3, 99.9);

        printCarInfo(seat);
        printCarInfo(audi);
    }

    private void printCarInfo(Car car) {
        System.out.printf(PRINT_TEMPLATE, car.getModel(), car.getColor(), car.getHorsePower())
                .println();

        System.out.println(car.toString());
    }
}
