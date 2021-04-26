public class Person {

    private static final String TO_STRING_TEMPLATE = "%s %s gets %s leva.";

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
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
    private double getSalary() {
        return this.salary;
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
    private void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double number) {
        double percentage = number / 100;

        if (this.getAge() < 30) {
            this.setSalary(this.getSalary() + ((this.getSalary() * (percentage) / 2)));
        } else {
            this.setSalary(this.getSalary() + this.getSalary() * percentage);
        }
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE,
                this.getFirstName(), this.getLastName(), this.getSalary());
    }
}
