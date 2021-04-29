public class Engine {

    public Engine() {
    }

    public void run() {
        StackOfStrings<String> stackOfStrings = new StackOfStrings<>();

        stackOfStrings.push("Ivan");
        stackOfStrings.push("Ivan Ventsislavov");
        stackOfStrings.push("Ivan Ventsislavov Ivanov");

        System.out.println(stackOfStrings.isEmpty());
        System.out.println(stackOfStrings.peek());

        System.out.println(stackOfStrings.pop());
        System.out.println(stackOfStrings.pop());
        System.out.println(stackOfStrings.pop());
    }
}
