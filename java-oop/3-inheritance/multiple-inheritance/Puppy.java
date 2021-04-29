public class Puppy extends Dog {

    private static final String WEEPING_MESSAGE = "weeping…";

    public Puppy() {
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public void bark() {
        super.bark();
    }

    public void weep() {
        System.out.println(WEEPING_MESSAGE);
    }
}
