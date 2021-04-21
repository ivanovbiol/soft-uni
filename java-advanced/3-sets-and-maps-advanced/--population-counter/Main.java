import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String COUNTRY_TOTAL_POPULATION_PRINT_TEMPLATE = "%s (total population: %d)";
    private static final String CITY_POPULATION_PRINT_TEMPLATE = "=>%s: %d";
    private static final String END_COMMAND = "report";
    private static final char CHARACTER_DELIMITER = '|';

    public static void main(String[] args) {
         readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> countriesMap = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> citiesMap = new LinkedHashMap<>();

        String nextLine = readStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            String city = nextLine.substring(0, nextLine.indexOf(CHARACTER_DELIMITER));
            String country = nextLine.substring(nextLine.indexOf(CHARACTER_DELIMITER) + 1,
                    nextLine.lastIndexOf(CHARACTER_DELIMITER));
            int population = Integer
                    .parseInt(nextLine.substring(nextLine.lastIndexOf(CHARACTER_DELIMITER) + 1));

            countriesMap.putIfAbsent(country, 0);
            int newCountryPopulation = countriesMap.get(country) + population;
            countriesMap.put(country, newCountryPopulation);

            citiesMap.putIfAbsent(country, new LinkedHashMap<>());
            citiesMap.get(country).putIfAbsent(city, 0);
            int newCityPopulation = citiesMap.get(country).get(city) + population;
            citiesMap.get(country).put(city, newCityPopulation);

            nextLine = readStringInput(scanner);
        }

        printResult(countriesMap, citiesMap);
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void printResult(Map<String, Integer> countriesMap,
            Map<String, Map<String, Integer>> citiesMap) {
        countriesMap
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> {
                    String country = entry.getKey();
                    int population = entry.getValue();

                    System.out.printf(
                            COUNTRY_TOTAL_POPULATION_PRINT_TEMPLATE, country, population)
                            .println();

                    citiesMap
                            .get(country)
                            .entrySet()
                            .stream()
                            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                            .forEach(cityEntry -> {
                                String city = cityEntry.getKey();
                                int cityPopulation = cityEntry.getValue();

                                System.out.printf(
                                        CITY_POPULATION_PRINT_TEMPLATE, city, cityPopulation)
                                        .println();
                            });
                });
    }
}