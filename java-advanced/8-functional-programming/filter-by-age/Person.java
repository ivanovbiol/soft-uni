public class Person {

    private static final String SPACE_SIGN = " ";
    private static final String AGE_CONDITION = "age";
    private static final String PRINT_TEMPLATE = "%s - %d";

    private String name;
    private int age;

    // The Person class is defined in Main class, so the constructor can be private
    // Actually all Person methods can be private
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

    public String printPersonData(String printFormat) {
        if (printFormat.contains(SPACE_SIGN)) {
            return String.format(PRINT_TEMPLATE, this.name, this.age);
        } else if (printFormat.equals(AGE_CONDITION)) {
            return String.valueOf(this.getAge());
        } else {
            return this.getName();
        }
    }
}
