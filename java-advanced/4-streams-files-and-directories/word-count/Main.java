import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static final String WRITE_TEMPLATE = "%s - %d";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        // The file paths should be customised from every user of the program
        // depending on the file location
        String inputPathName = "C:\\words.txt";
        String inputQuerySearchPathName = "C:\\text.txt";
        String outputPathName = "C:\\results.txt";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPathName));

            Set<String> setOfWords = fillSetOfWords(bufferedReader);
            bufferedReader.close();
            Map<String, Integer> wordsMap = fillWordsMap(setOfWords);

            BufferedReader targetBufferedReader = new BufferedReader(
                    new FileReader(inputQuerySearchPathName));
            List<String> targetWordsList = fillTargetWordsList(targetBufferedReader);
            targetBufferedReader.close();

            wordsMap
                    .forEach((key, value) -> {
                        String keyAsLowerCase = key.toLowerCase();
                        int counter = (int) targetWordsList
                                .stream()
                                .filter(e -> e.equals(keyAsLowerCase))
                                .count();
                        wordsMap.put(key, counter);
                    });

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPathName));

            wordsMap
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(entry -> {
                        try {
                            bufferedWriter.write(
                                    String.format(WRITE_TEMPLATE, entry.getKey(), entry.getValue()));
                            bufferedWriter.write(System.lineSeparator());
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });

            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static Set<String> fillSetOfWords(BufferedReader bufferedReader) throws IOException {
        return new LinkedHashSet<>(
                Arrays.asList(bufferedReader.readLine().split("\\s+")));
    }

    private static Map<String, Integer> fillWordsMap(Set<String> setOfWords) {
        Map<String, Integer> wordsMap = new LinkedHashMap<>();

        setOfWords
                .forEach(word -> wordsMap.put(word, 0));

        return wordsMap;
    }

    private static List<String> fillTargetWordsList(BufferedReader targetBufferedReader) {
        List<String> targetWordsList = new LinkedList<>();

        try {
            String line = targetBufferedReader.readLine();

            while (line != null) {
                targetWordsList.addAll(
                        Arrays
                                .stream(line.toLowerCase().split("\\s+"))
                                .collect(Collectors.toList()));
                line = targetBufferedReader.readLine();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return targetWordsList;
    }
}