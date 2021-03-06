public class Dog extends Animal {

    private static final String EATING_MESSAGE = "barking…";

    @Override
    protected void eat() {
        super.eat();
    }

    protected void bark() {
        System.out.println(EATING_MESSAGE);
    }
}
