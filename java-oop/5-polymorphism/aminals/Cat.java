public class Cat extends Animal {

    private static final String MEEOW_MESSAGE = "MEEOW";

    public Cat(String name, String favouriteFood) {
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
                this.getName(), this.getFavouriteFood(), MEEOW_MESSAGE);
    }
}
