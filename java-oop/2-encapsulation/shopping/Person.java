package shopping;

import static shopping.Messages.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private double money;
    private List<Product> badOfProducts;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.setBadOfProducts(new LinkedList<>());
    }

    // Getters
    public String getName() {
        return this.name;
    }
    private double getMoney() {
        return this.money;
    }
    private List<Product> getBadOfProducts() {
        return this.badOfProducts;
    }

    // Setters
    private void setName(String name) {
        if (StringValidator.isNotValidName(name)){
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
        this.name = name;
    }
    private void setMoney(double money) {
        if (DoubleValidator.areNotValidMoney(money)) {
            throw new IllegalArgumentException(INVALID_MONEY_MESSAGE);
        }
        this.money = money;
    }
    private void setBadOfProducts(List<Product> badOfProducts) {
        this.badOfProducts = badOfProducts;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.getMoney()) {
            throw new IllegalArgumentException(
                    String.format(PERSON_CAN_NOT_AFFORD_PRODUCT_MESSAGE_TEMPLATE,
                            this.getName(), product.getName()));
        }

        this.getBadOfProducts().add(product);
        this.setMoney(this.getMoney() - product.getCost());
        System.out.printf(
                PERSON_BOUGHT_PRODUCT_MESSAGE_TEMPLATE, this.getName(), product.getName())
                .println();
    }

    @Override
    public String toString() {
        if (this.getBadOfProducts().isEmpty()) {
            return String.format(PERSON_BOUGHT_NOTHING_TEMPLATE, this.getName());
        }

        return String.format(
                PERSON_TO_STRING_TEMPLATE, this.getName(),
                this.getBadOfProducts()
                        .stream()
                        .map(Product::toString)
                        .collect(Collectors.joining(COMMA_AND_SPACE_DELIMITER)));
    }
}
