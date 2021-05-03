import java.io.Serializable;

public interface Car extends Serializable {
    String DOUBLE_FORMAT_PATTERN = "%f";

    int TIRES = 4;

    String TO_STRING_TEMPLATE = "This is %s produced in %s and have %d tires";

    String getModel();

    String getColor();

    int getHorsePower();

    String countryProduced();

    @Override
    String toString();
}
