public abstract class Hero {

    private String userName;
    private int level;

    protected Hero(String userName, int level) {
        this.userName = userName;
        this.level = level;
    }

    // Getters
    protected String getUserName() {
        return this.userName;
    }

    protected int getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %s",
                this.getClass().getName(),
                this.getUserName(),
                this.getLevel());
    }
}
