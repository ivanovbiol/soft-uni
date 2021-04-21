import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
            Scanner scanner = new Scanner(new FileInputStream(inputFilePath));
            PrintWriter printWriter = new PrintWriter(outputFilePath);

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    printWriter.println(number);
                }

                scanner.next();
            }

            printWriter.flush();
            printWriter.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}