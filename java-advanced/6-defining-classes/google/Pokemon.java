public class Pokemon {

    private static final String SPACE_TEMPLATE = " ";

    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.setName(name);
        this.setType(type);
    }

    //Getters
    private String getName() {
        return this.name;
    }
    private String getType() {
        return this.type;
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.getName())
                .append(SPACE_TEMPLATE)
                .append(this.getType())
                .append(System.lineSeparator())
                .toString();
    }
}
