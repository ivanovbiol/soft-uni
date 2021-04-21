import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        executeProgram();
    }

    private static void executeProgram() {
        String[] stringArray = create(5, "Ivan");
        // prints 5
        System.out.println(stringArray.length);
        // prints Ivan since all elements are Ivan
        System.out.println(stringArray[0]);

        Integer[] integerArray = create(10, 2);
        // prints 10
        System.out.println(integerArray.length);
        // prints 2 since all elements are 2
        System.out.println(integerArray[0]);


    }

    @SuppressWarnings("unchecked")
    private static <T> T[] create(int length, T item) {
        T[] tempArr = (T[]) Array.newInstance(item.getClass(), length);
        Arrays.fill(tempArr, item);
        return tempArr;
    }

    @SuppressWarnings("unchecked")
    // the parameter clazz can not be class, since class in reserved key word in java
    private static <T> T[] create(Class<T> clazz, int length, T item) {
        T[] tempArr = (T[]) Array.newInstance(clazz, length);
        Arrays.fill(tempArr, item);
        return tempArr;
    }
}