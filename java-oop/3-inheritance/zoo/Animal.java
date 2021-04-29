public abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // Getter
    protected String getName() {
        return this.name;
    }
}
