public class Pet implements Birthable, Nameable {

    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.setName(name);
        this.setBirthDate(birthDate);
    }

    // Getters
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
