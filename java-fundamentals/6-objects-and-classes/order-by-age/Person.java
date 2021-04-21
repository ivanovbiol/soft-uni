public class Person {

    private static final String PRINT_TEMPLATE = "%s with ID: %s is %d years old.";

    private String name;
    private String id;
    private int age;

    public Person(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    private String getName() {
        return this.name;
    }

    private String getId() {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(PRINT_TEMPLATE, this.getName(), this.getId(), this.getAge());
    }
}
