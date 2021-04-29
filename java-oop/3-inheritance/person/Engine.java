import java.util.Scanner;

public class Engine {

    public Engine() {
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        Child child = new Child(name, age);

        System.out.println(child.getName());
        System.out.println(child.getAge());
    }
}
