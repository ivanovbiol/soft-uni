public interface Rentable {

    String RENTABLE_TO_STRING_TEMPLATE = "Minimum rental period of %d days. Price per day %s";

    int getMinRentDay();

    double getPricePerDay();
}
