import java.util.*;
import java.util.function.Consumer;

public class Engine {

    public Engine() {
    }

    public void run() {
        List<Person> persons = new ArrayList<>();

        persons.add(new Bulgarian("Pesho"));
        persons.add(new European("Pesho"));
        persons.add(new Chinese("Pesho"));

        Consumer<Person> consumer = Engine::print;

        persons.forEach(consumer);
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }
}
