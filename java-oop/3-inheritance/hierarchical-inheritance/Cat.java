public class Cat extends Animal {

    private static final String MEOWING_MESSAGE = "meowing…";

    public Cat() {
    }

    @Override
    public void eat() {
        super.eat();
    }

    public void meow() {
        System.out.println(MEOWING_MESSAGE);
    }
}
