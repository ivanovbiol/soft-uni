import java.util.Scanner;

public class Engine {

    private static final String SURFACE_AREA_PRINT_TEMPLATE = "Surface Area - %.2f";
    private static final String LATERAL_SURFACE_AREA_PRINT_TEMPLATE = "Lateral Surface Area - %.2f";
    private static final String VOLUME_PRINT_TEMPLATE = "Volume - %.2f";

    public Engine() {
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);

        double length = readDoubleNumber(scanner);
        double width = readDoubleNumber(scanner);
        double height = readDoubleNumber(scanner);

        try {
            Box box = new Box(length, width, height);
            System.out.printf(
                    SURFACE_AREA_PRINT_TEMPLATE, box.calculateSurfaceArea()).println();
            System.out.printf(
                    LATERAL_SURFACE_AREA_PRINT_TEMPLATE, box.calculateLateralSurfaceArea()).println();
            System.out.printf(
                    VOLUME_PRINT_TEMPLATE, box.calculateVolume()).println();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private static double readDoubleNumber(Scanner scanner) {
        return Double.parseDouble(scanner.nextLine());
    }
}