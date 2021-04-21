public class Scale<T extends Comparable<T>> {

    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        return this.left.compareTo(this.right) < 0 ? this.right :
                this.left.compareTo(this.right) > 0 ? this.left : null;
    }
}
