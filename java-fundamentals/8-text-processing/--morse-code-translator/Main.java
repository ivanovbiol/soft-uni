import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<String, String> MORSE_CODE_MAP = new LinkedHashMap<>();
    private static final String SPACE_SIGN = " ";
    private static final String PIPE_SIGN = "|";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {

        addMorseCodeInMap();

        String[] encryptedMessage = readStringArray();

        StringBuilder stringBuilder = new StringBuilder();

        Arrays
                .stream(encryptedMessage)
                .forEach(e ->
                        stringBuilder
                                .append(PIPE_SIGN.equals(e) ? SPACE_SIGN : MORSE_CODE_MAP.get(e)));

        System.out.println(stringBuilder.toString());
    }

    private static void addMorseCodeInMap() {
        MORSE_CODE_MAP.put(".-", "A");
        MORSE_CODE_MAP.put("-...", "B");
        MORSE_CODE_MAP.put("-.-.", "C");
        MORSE_CODE_MAP.put("-..", "D");
        MORSE_CODE_MAP.put(".", "E");
        MORSE_CODE_MAP.put("..-.", "F");
        MORSE_CODE_MAP.put("--.", "G");
        MORSE_CODE_MAP.put("....", "H");
        MORSE_CODE_MAP.put("..", "I");
        MORSE_CODE_MAP.put(".---", "J");
        MORSE_CODE_MAP.put("-.-", "K");
        MORSE_CODE_MAP.put(".-..", "L");
        MORSE_CODE_MAP.put("--", "M");
        MORSE_CODE_MAP.put("-.", "N");
        MORSE_CODE_MAP.put("---", "O");
        MORSE_CODE_MAP.put(".--.", "P");
        MORSE_CODE_MAP.put("--.-", "Q");
        MORSE_CODE_MAP.put(".-.", "R");
        MORSE_CODE_MAP.put("...", "S");
        MORSE_CODE_MAP.put("-", "T");
        MORSE_CODE_MAP.put("..-", "U");
        MORSE_CODE_MAP.put("...-", "V");
        MORSE_CODE_MAP.put(".--", "W");
        MORSE_CODE_MAP.put("-..-", "X");
        MORSE_CODE_MAP.put("-.--", "Y");
        MORSE_CODE_MAP.put("--..", "Z");
    }

    private static String[] readStringArray() {
        return new Scanner(System.in).nextLine().split("\\s+");
    }
}
