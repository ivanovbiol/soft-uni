import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() throws IOException {
        // The file paths should be customised from every user of the program
        // depending on the file location
        String inputFilePath = "C:\\input.txt";
        String outputFilePath = "C:\\output.txt";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath));

            List<String> lines =
                    bufferedReader.lines()
                    .map(String::valueOf)
                    .collect(Collectors.toList());

            for (int index = 0; index < lines.size(); index++) {
                if ((index + 1) % 3 == 0) {
                    bufferedWriter.write(lines.get(index));
                    bufferedWriter.write(System.lineSeparator());
                }
            }

            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}