package pizza;

import static pizza.Constants.*;
import static pizza.Messages.*;

import java.util.Scanner;

public class Engine {

    private boolean errorOccurred;

    public Engine() {
        this.setErrorOccurred(FALSE);
    }

    // Getter
    private boolean getErrorOccurred() {
        return this.errorOccurred;
    }

    // Setter
    private void setErrorOccurred(boolean errorOccurred) {
        this.errorOccurred = errorOccurred;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Pizza pizza = null;
        Dough dough = null;
        Topping topping = null;

        String nextLine = readStringLine(scanner);

        while (isNotEndCommand(nextLine)) {
            String command = nextLine.split(SPLIT_DELIMITER)[0];

            switch (command) {
                case PIZZA_COMMAND:
                    pizza = createPizza(nextLine);
                    break;
                case DOUGH_COMMAND:
                    dough = createDough(nextLine);
                    if (!this.getErrorOccurred()) {
                        pizza.setDough(dough);
                    }
                    break;
                case TOPPING_COMMAND:
                    topping = createTopping(nextLine);
                    if (!this.getErrorOccurred()) {
                        pizza.addTopping(topping);
                    }
                    break;
            }

            if (this.getErrorOccurred() == TRUE) {
                break;
            }

            nextLine = readStringLine(scanner);
        }

        printOverallCalories(pizza, dough);
    }

    private String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private boolean isNotEndCommand(String nextLine) {
        return !END_COMMAND.equals(nextLine);
    }

    private Pizza createPizza(String inputData) {
        String pizzaName = inputData.split(SPLIT_DELIMITER)[1];
        int numberOfToppings = Integer.parseInt(inputData.split(SPLIT_DELIMITER)[2]);

        try {
            return new Pizza(pizzaName, numberOfToppings);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            this.setErrorOccurred(TRUE);
            return null;
        }
    }

    private Dough createDough(String inputData) {
        String flourType = inputData.split(SPLIT_DELIMITER)[1];
        String bakingTechnique = inputData.split(SPLIT_DELIMITER)[2];
        double weight = Double.parseDouble(inputData.split(SPLIT_DELIMITER)[3]);

        try {
            return new Dough(flourType, bakingTechnique, weight);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            this.setErrorOccurred(TRUE);
            return null;
        }
    }

    private Topping createTopping(String inputData) {
        String toppingType = inputData.split(SPLIT_DELIMITER)[1];
        double weight = Double.parseDouble(inputData.split(SPLIT_DELIMITER)[2]);

        try {
            return new Topping(toppingType, weight);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            this.setErrorOccurred(TRUE);
            return null;
        }
    }

    private void printOverallCalories(Pizza pizza, Dough dough) {
        if (!this.getErrorOccurred()) {
            System.out.printf(TOTAL_PIZZA_CALORIES_PRINT_TEMPLATE, pizza.getName(),
                    pizza.getOverallCalories()).println();
        }
    }
}
