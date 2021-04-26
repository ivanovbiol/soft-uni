public class Person {

    private static final String TO_STRING_TEMPLATE = "%s %s gets %s leva.";
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

    // Setters - they should be public
    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException(INVALID_FIRST_NAME_MESSAGE);
        }
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException(INVALID_LAST_NAME_MESSAGE);
        }
        this.lastName = lastName;
    }
    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(INVALID_AGE_MESSAGE);
        }
        this.age = age;
    }
    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException(INVALID_SALARY_MESSAGE);
        }
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
