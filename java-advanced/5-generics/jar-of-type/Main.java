
public class Main {

    public static void main(String[] args) {
        executeProgram();
    }

    private static void executeProgram() {
        Jar<Integer> integerJar = new Jar<>();

        integerJar.add(1);
        integerJar.add(2);
        integerJar.add(3);

        // prints 3
        System.out.println(integerJar.remove());

        Jar<String> stringJar = new Jar<>();

        stringJar.add("Pesho");
        stringJar.add("Gosho");
        stringJar.add("Haralampi");

        // prints Haralampi
        System.out.println(stringJar.remove());
    }
}