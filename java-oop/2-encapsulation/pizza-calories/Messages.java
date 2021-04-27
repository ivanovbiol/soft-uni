package pizza;

public class Messages {

    private Messages() {
    }

    public static final String END_COMMAND = "END";

    public static final String PIZZA_COMMAND = "Pizza";

    public static final String DOUGH_COMMAND = "Dough";

    public static final String TOPPING_COMMAND = "Topping";

    public static final String INVALID_DOUGH_TYPE = "Invalid type of dough.";

    public static final String INVALID_DOUGH_WEIGHT = "Dough weight should be in the range [1..200].";

    public static final String INVALID_TOPPING_TYPE_FORMAT = "Cannot place %s on top of your pizza.";

    public static final String INVALID_TOPPING_WEIGHT_FORMAT = "%s weight should be in the range [1..50].";

    public static final String INVALID_PIZZA_NAME = "Pizza name should be between 1 and 15 symbols.";

    public static final String INVALID_NUMBER_OF_TOPPINGS = "Number of toppings should be in range [0..10].";

    public static final String TOTAL_PIZZA_CALORIES_PRINT_TEMPLATE = "%s - %.2f";
}
