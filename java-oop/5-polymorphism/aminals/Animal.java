public abstract class Animal {

    protected static final String EXPLAIN_SELF_TEMPLATE = "I am %s and my favourite food is %s\n%s";

    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.setName(name);
        this.setFavouriteFood(favouriteFood);
    }

    // Getters
    protected String getName() {
        return this.name;
    }
    protected String getFavouriteFood() {
        return this.favouriteFood;
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    protected abstract String explainSelf();
}