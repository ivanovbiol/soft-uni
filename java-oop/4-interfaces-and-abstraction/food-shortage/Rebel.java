public class Rebel implements Buyer, Person {

    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
        this.setFood(0);
    }

    // Getters
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public int getAge() {
        return this.age;
    }
    public String getGroup() {
        return this.group;
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
    private void setGroup(String group) {
        this.group = group;
    }
    private void setFood(int food) {
        this.food = food;
    }

    @Override
    public void buyFood() {
        this.setFood(this.getFood() + 5);
    }
}
