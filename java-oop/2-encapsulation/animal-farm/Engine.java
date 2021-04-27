import java.util.Scanner;

public class Engine {

    public Engine() {
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        String name = readStringLine(scanner);
        int age = readIntNumber(scanner);

        try {
            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken.toString());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }

    }

    private String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}