import java.util.LinkedList;
import java.util.List;

public class GenericBox<T> implements Comparable<T> {

    private List<T> elements;

    public GenericBox() {
        this.elements = new LinkedList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    @Override
    public int compareTo(T element) {
        return (int) this.elements
                .stream()
                .filter(e -> String.valueOf(e).compareTo(String.valueOf(element)) > 0)
                .count();
    }
}
