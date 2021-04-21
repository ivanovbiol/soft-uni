import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String UNKNOWN_LANGUAGE = "unknown";
    private static final String ENGLISH_LANGUAGE = "English";
    private static final String SPANISH_LANGUAGE = "Spanish";

    public static void main(String[] args) {

        String country = readCountry();

        System.out.println(printLanguage(country));

    }

    private static String readCountry() {

        return new Scanner(System.in).nextLine();

    }

    private static String printLanguage(String country) {

        List<String> englishCountries = List.of("England", "USA");
        List<String> spanishCountries = List.of("Spain", "Argentina", "Mexico");

        return englishCountries.contains(country) ? ENGLISH_LANGUAGE : spanishCountries.contains(country) ? SPANISH_LANGUAGE : UNKNOWN_LANGUAGE;
        
    }
}
