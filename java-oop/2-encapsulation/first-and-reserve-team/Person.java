public class Person {

    private static final String INVALID_FIRST_NAME_MESSAGE = "First name cannot be less than 3 symbols";
    private static final String INVALID_LAST_NAME_MESSAGE = "Last name cannot be less than 3 symbols";
    private static final String INVALID_AGE_MESSAGE = "Age cannot be zero or negative integer";
    private static final String INVALID_SALARY_MESSAGE = "Salary cannot be less than 460 leva";

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
    private String getFirstName() {
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
        if (firstName.length() < 3) {
            throw new IllegalArgumentException(INVALID_FIRST_NAME_MESSAGE);
        }
        this.firstName = firstName;
    }
    private void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException(INVALID_LAST_NAME_MESSAGE);
        }
        this.lastName = lastName;
    }
    private void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(INVALID_AGE_MESSAGE);
        }
        this.age = age;
    }
    private void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException(INVALID_SALARY_MESSAGE);
        }
        this.salary = salary;
    }
}
