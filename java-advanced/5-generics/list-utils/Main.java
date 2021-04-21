import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        executeProgram();
    }

    private static void executeProgram() {
        List<Integer> integerList = List.of(1 , 2, 3, 4, 5, 6, 7, 8, 9);

        // prints 1
        System.out.println(ListUtils.getMin(integerList));
        //prints 9
        System.out.println(ListUtils.getMax(integerList));

        // prints thrown IllegalArgumentException
        try {
            System.out.println(ListUtils.getMin(new ArrayList<Integer>()));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Throwing IllegalArgumentException !");
        }
    }
}