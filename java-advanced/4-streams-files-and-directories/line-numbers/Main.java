import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static final String LINE_NUMBER_TEMPLATE = "%d. ";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        // The file paths should be customised from every user of the program
        // depending on the file location
        String inputPathName = "C:\\inputLineNumbers.txt";
        String outputPathName = "C:\\output.txt";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPathName));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPathName));

            int lineCounter = 1;
            String line = bufferedReader.readLine();

            while (line != null) {
                bufferedWriter.write(String.format(LINE_NUMBER_TEMPLATE, lineCounter++));
                bufferedWriter.write(line);
                bufferedWriter.write(System.lineSeparator());

                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}