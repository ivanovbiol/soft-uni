import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CustomList<T> {

    private static final String INVALID_INDEX_MESSAGE = "Invalid index";
    private static final String EMPTY_LIST_MESSAGE = "Empty list";
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    private List<T> getElements() {
        return elements;
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
        if (isValidIndex(index)) {
            return this.getElements().remove(index);
        }
        throw new IndexOutOfBoundsException(INVALID_INDEX_MESSAGE);
    }

    private boolean isValidIndex(int index) {
        if (index >= 0 && index < this.getElements().size()) {
            return true;
        }
        throw new IndexOutOfBoundsException(INVALID_INDEX_MESSAGE);
    }

    public boolean contains(T element) {
        return this.getElements().contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        if (areValidIndexes(firstIndex, secondIndex)) {
            Collections.swap(this.getElements(), firstIndex, secondIndex);
        }
    }

    private boolean areValidIndexes(int firstIndex, int secondIndex) {
        return isValidIndex(firstIndex) && isValidIndex(secondIndex);
    }

    public int countGreaterThan(T element) {
        return (int) this.getElements()
                .stream()
                .filter(e -> String.valueOf(e).compareTo(String.valueOf(element)) > 0)
                .count();
    }

    @SuppressWarnings("Unckecked")
    public T getMax() {
        if (this.getElements().isEmpty()) {
            throw new NullPointerException(EMPTY_LIST_MESSAGE);
        }
        return (T) this.getElements()
                .stream()
                .map(String::valueOf)
                .max(Comparator.naturalOrder())
                .orElse(NoSuchElementException.class.toString());
    }

    @SuppressWarnings("Unckecked")
    public T getMin() {
        if (this.getElements().isEmpty()) {
            throw new NullPointerException(EMPTY_LIST_MESSAGE);
        }

        return (T) this.getElements()
                .stream()
                .map(String::valueOf)
                .min(Comparator.naturalOrder())
                .orElse(NoSuchElementException.class.toString());
    }

    public String print() {
        return this.getElements()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
