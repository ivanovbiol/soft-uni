import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    private static final String PRINT_TEMPLATE = "Vowels: %d%nConsonants: %d%nPunctuation: %d";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        // The file paths should be customised from every user of the program
        // depending on the file location
        String inputPathName = "C:\\input.txt";
        String outputPathName = "C:\\output.txt";

        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        List<Character> punctuationMarks = List.of('!', ',', '.', '?');

        long vowelsCounter = 0;
        long consonantsCounter = 0;
        long punctuationsCounter = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPathName));

            String line = bufferedReader.readLine();

            while (line != null) {
                vowelsCounter += line.chars().filter(e -> vowels.contains((char) e)).count();
                punctuationsCounter += line.chars().filter(e -> punctuationMarks.contains((char) e))
                        .count();
                consonantsCounter += line.chars()
                        .filter(e -> !vowels.contains((char) e) && !punctuationMarks
                                .contains((char) e) && e != ' ').count();

                line = bufferedReader.readLine();
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPathName));
            bufferedWriter.write(String
                    .format(PRINT_TEMPLATE, vowelsCounter, consonantsCounter, punctuationsCounter));

            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}