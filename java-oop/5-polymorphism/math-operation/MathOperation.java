import java.util.Arrays;

public class MathOperation implements Addable {

    public MathOperation() {
    }

    @Override
    public int add(int number) {
        return number;
    }

    public int add(int... numbers) {
        return Arrays.stream(numbers).sum();
    }
}