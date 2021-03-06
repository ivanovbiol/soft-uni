public class Person {

    private static final String PRINT_TEMPLATE = "%s - %d";

    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    // Getters
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(PRINT_TEMPLATE, this.getName(), this.getAge());
    }
}
