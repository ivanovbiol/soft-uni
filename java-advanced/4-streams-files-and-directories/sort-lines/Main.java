import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws InvalidPathException{
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() throws InvalidPathException {
        // The file paths should be customised from every user of the program
        // depending on the file location
        String inputFilePath = "C:\\input.txt";
        String outputFilePath = "C:\\output.txt";

        try {
            Path inputPath = Paths.get(inputFilePath);
            Path outputPath = Paths.get(outputFilePath);

            BufferedReader bufferedReader = Files.newBufferedReader(inputPath);
            BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath);

            bufferedReader
                    .lines()
                    .map(String::valueOf)
                    .sorted()
                    .forEach(line -> {
                        try {
                            if (!line.isEmpty()) {
                                bufferedWriter.write(line);
                                bufferedWriter.write(System.lineSeparator());
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });

            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (InvalidPathException | IOException exception) {
            exception.printStackTrace();
        }
    }
}