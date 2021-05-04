public class Citizen implements Identifiable {

    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
    }

    // Getters
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    @Override
    public String getId() {
        return this.id;
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setAge(int age) {
        this.age = age;
    }
    private void setId(String id) {
        this.id = id;
    }
}
