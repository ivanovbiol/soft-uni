public class Dog extends Animal {

    private static final String DJAAF_MESSAGE = "DJAAF";

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    // Getters
    @Override
    protected String getName() {
        return super.getName();
    }
    @Override
    protected String getFavouriteFood() {
        return super.getFavouriteFood();
    }

    @Override
    public String explainSelf() {
        return String.format(EXPLAIN_SELF_TEMPLATE,
                this.getName(), this.getFavouriteFood(), DJAAF_MESSAGE);
    }
}
