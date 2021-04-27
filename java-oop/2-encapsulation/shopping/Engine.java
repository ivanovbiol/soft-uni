package shopping;

import static shopping.Messages.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Engine {

    private List<Person> personList;
    private List<Product> productList;

    public Engine() {
        this.setPersonList(new LinkedList<>());
        this.setProductList(new LinkedList<>());
    }

    // Getters
    private List<Person> getPersonList() {
        return this.personList;
    }

    private List<Product> getProductList() {
        return this.productList;
    }

    // Setters
    private void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    private void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        String[] personArray = readStringArray(scanner);

        for (String currentInput : personArray) {
            addNewPerson(currentInput);
        }

        String[] productArray = readStringArray(scanner);

        for (String currentInput : productArray) {
            addNewProduct(currentInput);
        }

        String nextLine = readStringLine(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            String queryPersonName = nextLine.split(SPACE_DELIMITER)[0];
            String queryProductName = nextLine.split(SPACE_DELIMITER)[1];

            addProductToPersonBag(queryPersonName, queryProductName);

            nextLine = readStringLine(scanner);
        }

        printPeopleWithProducts();
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split(INPUT_DELIMITER);
    }

    private void addNewPerson(String currentInput) {
        String personName = currentInput.split(NAME_AND_MONEY_DELIMITER)[0];
        double personMoney = Double.parseDouble(currentInput.split(NAME_AND_MONEY_DELIMITER)[1]);

        try {
            Person person = new Person(personName, personMoney);
            this.getPersonList().add(person);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private void addNewProduct(String currentInput) {
        String productName = currentInput.split(NAME_AND_MONEY_DELIMITER)[0];
        double productCost = Double.parseDouble(currentInput.split(NAME_AND_MONEY_DELIMITER)[1]);

        try {
            Product product = new Product(productName, productCost);
            this.getProductList().add(product);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private void addProductToPersonBag(String queryPersonName, String queryProductName) {
        Predicate<String> personNamePredicate = personName -> personName.equals(queryPersonName);
        Predicate<Person> personPredicate = person -> person.getName().equals(queryPersonName);
        Predicate<String> productNamePredicate = productName -> productName
                .equals(queryProductName);
        Predicate<Product> productPredicate = product -> product.getName().equals(queryProductName);

        if (this.getPersonList().stream().map(Person::getName).anyMatch(personNamePredicate)) {
            if (this.getProductList().stream().map(Product::getName)
                    .anyMatch(productNamePredicate)) {
                Product currentProduct =
                        this.getProductList()
                                .stream()
                                .filter(productPredicate)
                                .findFirst()
                                .get();

                Person currentPerson =
                        this.getPersonList()
                                .stream()
                                .filter(personPredicate)
                                .findFirst()
                                .get();

                try {
                    currentPerson.buyProduct(currentProduct);
                } catch (IllegalArgumentException illegalArgumentException) {
                    System.out.println(illegalArgumentException.getMessage());
                }
            }
        }
    }

    private void printPeopleWithProducts() {
        Consumer<String> stringConsumer = System.out::println;

        this.getPersonList()
                .stream()
                .map(Person::toString)
                .forEach(stringConsumer);
    }
}
