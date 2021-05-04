public class Citizen implements Identifiable, Buyer, Person {

    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthDate(birthDate);
        this.setFood(0);
    }

    // Getters
    @Override
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
    @Override
    public int getFood() {
        return this.food;
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
    private void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    private void setFood(int food) {
        this.food = food;
    }

    @Override
    public void buyFood() {
        this.setFood(this.getFood() + 10);
    }
}
