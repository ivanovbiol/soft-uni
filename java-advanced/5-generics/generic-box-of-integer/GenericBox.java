import java.util.LinkedList;
import java.util.Queue;

public class GenericBox<T> {

    private static final String TYPE_CLASS_NAME_PRINT_TEMPLATE = "%s: ";
    private Queue<T> elements;

    public GenericBox() {
        this.elements = new LinkedList<>();
    }

    public void add(T element) {
        this.elements.offer(element);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        while (!this.elements.isEmpty()) {
            stringBuilder.append(String.format(TYPE_CLASS_NAME_PRINT_TEMPLATE,
                    this.elements.peek().getClass().getName()));
            stringBuilder.append(this.elements.poll());
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
