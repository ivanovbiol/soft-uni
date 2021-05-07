package farm;

import static farm.messages.Constants.*;
import static farm.messages.Messages.UNKNOWN_ANIMAL_TYPE;

import farm.animal.*;
import farm.food.*;
import farm.messages.Messages;
import java.util.*;

public class Engine {

    private List<Animal> animals;

    public Engine() {
        this.setAnimals(new LinkedList<>());
    }

    // Getter
    private List<Animal> getAnimals() {
        return this.animals;
    }

    // Setter
    private void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        String nextLine = readStringLine(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            String[] animalInfo = nextLine.split(SPLIT_DELIMITER);
            Animal animal;
            try {
                animal = createAnimal(animalInfo);
                animal.makeSound();
                String[] foodInfo = readStringArray(scanner);
                Food food = createFood(foodInfo);
                try {
                    animal.eat(food);
                } catch (IllegalArgumentException illegalArgumentException) {
                    System.out.println(illegalArgumentException.getMessage());
                }
                addAnimalToList(animal);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }

            nextLine = readStringLine(scanner);
        }

        printAnimals();
    }

    private String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private Animal createAnimal(String[] animalInfo) {
        String animalType = animalInfo[0];
        String animalName = animalInfo[1];
        double animalWeight = Double.parseDouble(animalInfo[2]);
        String animalLivingRegion = animalInfo[3];

        switch (animalType) {
            case MOUSE:
                return new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
            case CAT:
                String breed = animalInfo[4];
                return new Cat(animalName, animalType, animalWeight, animalLivingRegion, breed);
            case TIGER:
                return new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
            case ZEBRA:
                return new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
            default:
                throw new IllegalArgumentException(String.format(UNKNOWN_ANIMAL_TYPE, animalType));
        }
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split(SPLIT_DELIMITER);
    }

    private Food createFood(String[] foodInfo) {
        String foodType = foodInfo[0];
        int quantity = Integer.parseInt(foodInfo[1]);

        switch (foodType) {
            case VEGETABLE:
                return new Vegetable(quantity);
            case MEAT:
                return new Meat(quantity);
            default:
                throw new IllegalArgumentException();
        }
    }

    private void addAnimalToList(Animal animal) {
        this.getAnimals().add(animal);
    }

    private void printAnimals() {
        this.getAnimals().forEach(System.out::println);
    }
}
