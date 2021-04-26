public class PriceCalculator {

    private static final String PRINT_TEMPLATE = "%.2f";

    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private DiscountType discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays, Season season,
            DiscountType discountType) {
        this.setPricePerDay(pricePerDay);
        this.setNumberOfDays(numberOfDays);
        this.setSeason(season);
        this.setDiscountType(discountType);
    }

    // Getters
    private double getPricePerDay() {
        return this.pricePerDay;
    }
    private int getNumberOfDays() {
        return this.numberOfDays;
    }
    private Season getSeason() {
        return this.season;
    }
    private DiscountType getDiscountType() {
        return this.discountType;
    }

    // Setters
    private void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    private void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
    private void setSeason(Season season) {
        this.season = season;
    }
    private void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public String calculateTotalPrice() {
        return String.format(PRINT_TEMPLATE, (this.getNumberOfDays() * this.getPricePerDay() *
                this.getSeason().getValue() * this.getDiscountType().getValue()));
    }
}
