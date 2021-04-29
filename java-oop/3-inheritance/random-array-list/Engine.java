public class Engine {

    public Engine() {
    }

    public void run() {
        RandomArrayList<String> randomArrayList = new RandomArrayList<>();

        randomArrayList.add("Ivan");
        randomArrayList.add("Ivan Ivanov");
        randomArrayList.add("Ivan Ventsislavov Ivanov");

        System.out.println(randomArrayList.getRandomElement());

        System.out.println(randomArrayList.toString());
    }
}
