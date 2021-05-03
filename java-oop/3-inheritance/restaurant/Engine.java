import java.math.BigDecimal;

public class Engine {

    public Engine() {
    }

    public void run() {
        Coffee coffee = new Coffee("coffee", 1.5);
        System.out.println(coffee.getName());
        System.out.println(coffee.getPrice());
        System.out.println(coffee.getMilliliters());
        System.out.println(coffee.getCaffeine());

        System.out.println("*******");

        Tea tea = new Tea("tea", BigDecimal.valueOf(2.5), 10.2);
        System.out.println(tea.getName());
        System.out.println(tea.getPrice());
        System.out.println(tea.getMilliliters());

        System.out.println("*******");

        Salmon salmon = new Salmon("salmon", BigDecimal.valueOf(12.54));
        System.out.println(salmon.getName());
        System.out.println(salmon.getPrice());
        System.out.println(salmon.getGrams());

        System.out.println("*******");

        Soup soup = new Soup("soup", BigDecimal.valueOf(7.26), 105.7);
        System.out.println(soup.getName());
        System.out.println(soup.getPrice());
        System.out.println(soup.getGrams());

        System.out.println("*******");

        Cake cake = new Cake("cake");
        System.out.println(cake.getName());
        System.out.println(cake.getPrice());
        System.out.println(cake.getGrams());
        System.out.println(cake.getCalories());
    }
}
