import java.util.*;
import java.util.stream.Collectors;

public class RandomArrayList<String> extends ArrayList<String> {

    private ArrayList<String> list;
    private Random random;

    public RandomArrayList() {
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    @Override
    public boolean add(String string) {
        return this.list.add(string);
    }

    public String getRandomElement() {
        String currentElement = this.list.get(random.nextInt(this.list.size()));
        this.list.remove(currentElement);
        return currentElement;
    }

    @Override
    public java.lang.String toString() {
        return this.list
                .stream()
                .map(java.lang.String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
