public class Dog extends Animal {

    private static final String EATING_MESSAGE = "barking…";

    public Dog() {
    }

    @Override
    public void eat() {
        super.eat();
    }

    public void bark() {
        System.out.println(EATING_MESSAGE);
    }
}
