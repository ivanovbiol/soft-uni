public class Engine {

    private static final String PRINT_TEMPLATE = "%s is %s color and have %s horse power";

    public Engine() {
    }

    public void run() {
        Car seat = new Seat("Leon", "gray", 110, "Spain");

        System.out.printf(
                PRINT_TEMPLATE, seat.getModel(), seat.getColor(), seat.getHorsePower())
                .println();

        System.out.println(seat.toString());
    }
}
