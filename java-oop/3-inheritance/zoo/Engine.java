
public class Engine {

    public Engine() {
    }

    public void run() {
        Lizard lizard = new Lizard("lizard");
        System.out.println(lizard.getName());

        Snake snake = new Snake("snake");
        System.out.println(snake.getName());

        Gorilla gorilla = new Gorilla("gorilla");
        System.out.println(gorilla.getName());

        Bear bear = new Bear("bear");
        System.out.println(bear.getName());
    }
}
