import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.InvalidPathException;

public class Main {

    public static void main(String[] args) throws InvalidPathException {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() throws InvalidPathException {
        // The file path should be customised from every user of the program
        // depending on the file location
        String pathName = "C:\\input.txt";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathName));

            String line = bufferedReader.readLine();
            long sum = 0L;

            while (line != null) {
                sum += line.chars().sum();

                line = bufferedReader.readLine();
            }

            System.out.println(sum);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}