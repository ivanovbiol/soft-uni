import java.util.Stack;

public class Jar<Type> {

    private Stack<Type> collection;

    public Jar () {
        this.collection = new Stack<>();
    }

    public void add(Type element) {
        this.collection.push(element);
    }

    public Type remove() {
        return this.collection.pop();
    }
}
