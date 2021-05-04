public class Engine {

    public Engine() {
    }

    public void run() {
        Animal cat = new Cat("Oscar", "Whiskas");
        Animal dog = new Dog("Rocky", "Meat");

        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());
    }
}
