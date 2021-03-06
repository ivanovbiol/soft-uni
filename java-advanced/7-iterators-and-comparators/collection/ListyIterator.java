package list_task;

import static list_task.StaticVariables.INVALID_OPERATION_EXCEPTION_MESSAGE;

import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {

    private List<String> elements;
    private int index;

    public ListyIterator(List<String> elements) {
        this.setElements(elements);
        this.setIndex(elements);
    }

    // Getters
    private List<String> getElements() {
        return this.elements;
    }

    private int getIndex() {
        return this.index;
    }

    // Setters
    private void setElements(List<String> elements) {
        this.elements = elements;
    }

    // Overload setIndex method
    private void setIndex(List<String> elements) {
        this.index = elements.size() != 0 ? 0 : -1;
    }

    private void setIndex(int index) {
        this.index = index;
    }

    public boolean move() {
        if (this.getIndex() < this.getElements().size() - 1) {
            this.setIndex(this.getIndex() + 1);
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.getIndex() < this.getElements().size() - 1;
    }

    public void print() {
        if (this.getIndex() < 0) {
            throw new InvalidParameterException(INVALID_OPERATION_EXCEPTION_MESSAGE);
        }
        System.out.println(this.getElements().get(this.getIndex()));
    }

    public void printAll() {
        StringBuilder stringBuilder = new StringBuilder();

        Iterator stringIterator = this.iterator();

        while (stringIterator.hasNext()) {
            stringBuilder.append(stringIterator.next()).append(" ");
        }

        System.out.println(stringBuilder.toString().trim());
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int iteratorIndex = 0;

            @Override
            public boolean hasNext() {
                return this.iteratorIndex < elements.size();
            }

            @Override
            public String next() {
                return elements.get(this.iteratorIndex++);
            }
        };
    }
}
