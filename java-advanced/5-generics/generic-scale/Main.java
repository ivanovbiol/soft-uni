
public class Main {

    public static void main(String[] args) {
        executeProgram();
    }

    private static void executeProgram() {
        Scale<Integer> firstIntegerScale = new Scale<>(1, 2);
        // prints 2
        System.out.println(firstIntegerScale.getHeavier());

        Scale<Integer> secondIntegerScale = new Scale<>(10, 10);
        // prints null
        System.out.println(secondIntegerScale.getHeavier());

        Scale<String> firstStringScale = new Scale<>("Ivan", "Pesho");
        // prints Pesho
        System.out.println(firstStringScale.getHeavier());

        Scale<String> secondStringScale = new Scale<>("Ivan", "Ivan");
        // prints null
        System.out.println(secondStringScale.getHeavier());

        Scale<Person> firstPersonScale = new Scale<>(new Person("Ivan", 92.5), new Person("Dragan", 101.3));
        // prints Dragan
        System.out.println(firstPersonScale.getHeavier());

        Scale<Person> secondPersonScale = new Scale<>(new Person("Ivan", 92.5), new Person("Dragan", 92.5));
        // prints null
        System.out.println(secondPersonScale.getHeavier());
    }
}