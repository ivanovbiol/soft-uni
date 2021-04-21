import java.util.LinkedList;
import java.util.List;

public class GenericBox<T> {

    private static final String TYPE_CLASS_NAME_PRINT_TEMPLATE = "%s: ";
    private List<T> elements;

    public GenericBox() {
        this.elements = new LinkedList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstElement = this.elements.get(firstIndex);
        T secondElement = this.elements.get(secondIndex);
        this.elements.set(firstIndex, secondElement);
        this.elements.set(secondIndex, firstElement);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        while (!this.elements.isEmpty()) {
            stringBuilder.append(String.format(TYPE_CLASS_NAME_PRINT_TEMPLATE,
                    this.elements.get(0).getClass().getName()));
            stringBuilder.append(this.elements.remove(0));
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
