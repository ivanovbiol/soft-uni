public class Person {

    private static final String TO_STRING_TEMPLATE = "%s %s is %d years old.";

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    // Getters
    public String getFirstName() {
        return this.firstName;
    }
    private String getLastName() {
        return this.lastName;
    }
    public int getAge() {
        return this.age;
    }

    // Setters
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    private void setLastName(String lastName) {
        this.lastName = lastName;
    }
    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE,
                this.getFirstName(), this.getLastName(), this.getAge());
    }
}
