package shopping;

public class Messages {

    private Messages() {
    }

    public static final String INVALID_NAME_MESSAGE = "Name cannot be empty";
    public static final String INVALID_MONEY_MESSAGE = "Money cannot be negative";

    public static final String END_COMMAND = "END";
    public static final String NAME_AND_MONEY_DELIMITER = "=";
    public static final String INPUT_DELIMITER = ";";
    public static final String SPACE_DELIMITER = " ";

    public static final String PERSON_CAN_NOT_AFFORD_PRODUCT_MESSAGE_TEMPLATE = "%s can't afford %s";
    public static final String PERSON_BOUGHT_PRODUCT_MESSAGE_TEMPLATE = "%s bought %s";
    public static final String PERSON_BOUGHT_NOTHING_TEMPLATE = "%s - Nothing bought";
    public static final String PERSON_TO_STRING_TEMPLATE = "%s - %s";
    public static final String COMMA_AND_SPACE_DELIMITER = ", ";
}
