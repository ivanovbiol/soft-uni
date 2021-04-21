package cat;

import static cat.StaticVariables.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Engine {

    private List<Cat> catsList;

    public Engine() {
        this.setCatsList(new LinkedList<>());
    }

    // Getter
    private List<Cat> getCatsList() {
        return this.catsList;
    }

    // Setter
    private void setCatsList(List<Cat> catsList) {
        this.catsList = catsList;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        String inputLine = readStringLine(scanner);

        while (!END_COMMAND.equals(inputLine)) {
            String typeOfCat = inputLine.split("\\s+")[0];
            String catName = inputLine.split("\\s+")[1];
            double doubleCatParameter = Double.parseDouble(inputLine.split("\\s+")[2]);

            Cat cat = null;

            switch (typeOfCat) {
                case SIAMESE_TEMPLATE:
                    cat = new Siamese(catName, doubleCatParameter);
                    break;
                case CYMRIC_TEMPLATE:
                    cat = new Cymric(catName, doubleCatParameter);
                    break;
                case STREET_EXTRAORDINAIRE_TEMPLATE:
                    cat = new StreetExtraordinaire(catName, doubleCatParameter);
                    break;
            }

            if (cat != null) {
                this.getCatsList().add(cat);
            }

            inputLine = readStringLine(scanner);
        }

        String queryCatName = readStringLine(scanner);

        printQueryCatInfo(queryCatName);
    }

    private String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private void printQueryCatInfo(String queryCatName) {
        this.getCatsList()
                .stream()
                .filter(cat -> cat.getName().equals(queryCatName))
                .findFirst()
                .ifPresent(System.out::println);
    }
}
