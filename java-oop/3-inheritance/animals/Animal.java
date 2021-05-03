public abstract class Animal {

    private static final String SPACE_SIGN = " ";

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    // Getters
    protected String getName() {
        return this.name;
    }
    protected int getAge() {
        return this.age;
    }
    protected String getGender() {
        return this.gender;
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setAge(int age) {
        this.age = age;
    }
    private void setGender(String gender) {
        this.gender = gender;
    }

    protected abstract String produceSound();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        stringBuilder.append(this.getName()).append(SPACE_SIGN);
        stringBuilder.append(this.getAge()).append(SPACE_SIGN);
        stringBuilder.append(this.getGender()).append(System.lineSeparator());
        stringBuilder.append(this.produceSound());

        return stringBuilder.toString();
    }
}
