public class Chicken {

    private static final String INVALID_NAME_MESSAGE = "Name cannot be empty.";
    private static final String INVALID_AGE_MESSAGE = "Age should be between 0 and 15.";
    private static final String TO_STRING_TEMPLATE = "Chicken %s (age %d) can produce %.2f eggs per day.";

    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    // Getters
    private String getName() {
        return this.name;
    }
    private int getAge() {
        return this.age;
    }

    // Setters
    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
        this.name = name;
    }
    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException(INVALID_AGE_MESSAGE);
        }
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (this.getAge() < 6) {
            return 2;
        } else if (this.getAge() < 11) {
            return 1;
        }
        return 0.75;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE, this.getName(), this.getAge(), this.productPerDay());
    }
}
