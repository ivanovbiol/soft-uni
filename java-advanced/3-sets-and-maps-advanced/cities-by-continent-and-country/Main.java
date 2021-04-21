import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String CONTINENT_PRINT_TEMPLATE = "%s:";
    private static final String COUNTRY_AND_CITIES_PRINT_TEMPLATE = "%s -> %s";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = readIntNumber(scanner);

        Map<String, Map<String, List<String>>> continentsCountriesAndCitiesMap =
                generateMap(scanner, numberOfLines);

        printContinentsCountriesAndCitiesMap(continentsCountriesAndCitiesMap);
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static Map<String, Map<String, List<String>>> generateMap(Scanner scanner,
            int numberOfLines) {
        Map<String, Map<String, List<String>>> continentsCountriesAndCitiesMap = new LinkedHashMap<>();

        while (numberOfLines-- > 0) {
            String[] continentsAndCountriesInfo = readStringArray(scanner);
            String continentName = continentsAndCountriesInfo[0];
            String countryName = continentsAndCountriesInfo[1];
            String cityName = continentsAndCountriesInfo[2];

            continentsCountriesAndCitiesMap.putIfAbsent(continentName, new LinkedHashMap<>());
            continentsCountriesAndCitiesMap.get(continentName)
                    .putIfAbsent(countryName, new LinkedList<>());
            continentsCountriesAndCitiesMap.get(continentName).get(countryName).add(cityName);
        }

        return continentsCountriesAndCitiesMap;
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private static void printContinentsCountriesAndCitiesMap(
            Map<String, Map<String, List<String>>> continentsCountriesAndCitiesMap) {
        continentsCountriesAndCitiesMap
                .forEach((key, value) -> {
                    System.out.printf(CONTINENT_PRINT_TEMPLATE, key).println();

                    value
                            .forEach((subKey, subValue) -> {
                                String allCitiesInACountry =
                                        String.join(", ", subValue);

                                System.out.printf(COUNTRY_AND_CITIES_PRINT_TEMPLATE, subKey,
                                        allCitiesInACountry).println();
                            });
                });
    }
}