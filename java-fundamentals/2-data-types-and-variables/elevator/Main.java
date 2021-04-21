import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());

        int courses = numberOfPeople < elevatorCapacity ? 1 :
                numberOfPeople % elevatorCapacity != 0 ? numberOfPeople / elevatorCapacity + 1 :
                        numberOfPeople / elevatorCapacity;

        System.out.println(courses);

    }
}