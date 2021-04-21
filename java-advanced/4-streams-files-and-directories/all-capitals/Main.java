import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;

public class Main {

    public static void main(String[] args) throws InvalidPathException{
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() throws InvalidPathException{
        // The file path should be customised from every user of the program
        // depending on the file location
        String inputPathName = "C:\\input.txt";
        String outputPathName = "C:\\output.txt";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPathName));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPathName));

            bufferedReader
                    .lines()
                    .forEach(element -> {
                        for (char currentChar : element.toCharArray()) {
                            if (!Character.isLetter(currentChar)
                                    || Character.isLetter(currentChar) && Character
                                    .isUpperCase(currentChar)) {
                                try {
                                    bufferedWriter.write(currentChar);
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                            } else {
                                try {
                                    bufferedWriter.write(Character.toUpperCase(currentChar));
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                            }
                        }

                        try {
                            bufferedWriter.write(System.lineSeparator());
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });

            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}