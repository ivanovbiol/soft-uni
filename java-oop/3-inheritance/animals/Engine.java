import java.util.Scanner;

public class Engine {

    private static final String STOP_COMMAND = "Beast!";
    private static final String INVALID_INPUT_MESSAGE = "Invalid input!";
    private static final String SPLIT_DELIMITER = "\\s+";
    private static final String DOG_COMMAND = "Dog";
    private static final String CAT_COMMAND = "Cat";
    private static final String FROG_COMMAND = "Frog";
    private static final String KITTENS_COMMAND = "Kittens";
    private static final String TOMCAT_COMMAND = "TOMCAT";

    public Engine() {
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String command = readStringLine(scanner);

        while (!STOP_COMMAND.equals(command)) {
            String animalData = readStringLine(scanner);

            try {
                if (isInvalidAnimalInfo(animalData)) {
                    throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
                }
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                command = readStringLine(scanner);
                continue;
            }

            String name = animalData.split(SPLIT_DELIMITER)[0];
            int age = Integer.parseInt(animalData.split(SPLIT_DELIMITER)[1]);
            String gender = animalData.split(SPLIT_DELIMITER)[2];

            switch (command) {
                case DOG_COMMAND:
                    System.out.println(new Dog(name, age, gender));
                    break;
                case CAT_COMMAND:
                    System.out.println(new Cat(name, age, gender));
                    break;
                case FROG_COMMAND:
                    System.out.println(new Frog(name, age, gender));
                    break;
                case KITTENS_COMMAND:
                    System.out.println(new Kitten(name, age));
                    break;
                case TOMCAT_COMMAND:
                    System.out.println(new Tomcat(name, age));
                    break;
            }

            command = readStringLine(scanner);
        }
    }

    private String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private boolean isInvalidAnimalInfo(String animalData) {
        if (animalData.split(SPLIT_DELIMITER).length != 3) {
            return true;
        }

        try {
            int tempAge = Integer.parseInt(animalData.split(SPLIT_DELIMITER)[1]);
            return tempAge <= 0;
        } catch (NumberFormatException numberFormatException) {
            return true;
        }
    }
}
