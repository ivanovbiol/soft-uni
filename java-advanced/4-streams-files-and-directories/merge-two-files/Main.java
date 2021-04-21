import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        // The file paths should be customised from every user of the program
        // depending on the file location
        String inputOnePathName = "C:\\inputOne.txt";
        String inputTwoPathName = "C:\\inputTwo.txt";
        String outputPathName = "C:\\merged.txt";

        try {
            BufferedReader firstBufferedReader = new BufferedReader(new FileReader(inputOnePathName));
            BufferedReader secondBufferedReader = new BufferedReader(new FileReader(inputTwoPathName));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPathName));

            String line = firstBufferedReader.readLine();

            while (line != null) {
                bufferedWriter.write(line);
                bufferedWriter.write(System.lineSeparator());
                line = firstBufferedReader.readLine();
            }

            firstBufferedReader.close();
            line = secondBufferedReader.readLine();

            while (line != null) {
                bufferedWriter.write(line);
                bufferedWriter.write(System.lineSeparator());
                line = secondBufferedReader.readLine();
            }

            secondBufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}