public class Person {

    private String name;
    private int age;

    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
