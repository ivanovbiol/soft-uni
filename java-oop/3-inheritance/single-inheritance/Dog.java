public class Dog extends Animal {

    private static final String EATING_MESSAGE = "barking…";

    public Dog() {
    }

    @Override
    protected void eat() {
        super.eat();
    }

    public void bark() {
        System.out.println(EATING_MESSAGE);
    }
}
