import java.util.ArrayList;

public class StackOfStrings<String> {

    private ArrayList<String> list;

    public StackOfStrings() {
        this.list = new ArrayList<>();
    }

    public void push(String element) {
        this.list.add(element);
    }

    public String pop() {
        return this.list.remove(this.list.size() - 1);
    }

    public String peek() {
        return this.list.get(this.list.size() - 1);
    }

    public boolean isEmpty() {
        return this.list.size() == 0;
    }
}
