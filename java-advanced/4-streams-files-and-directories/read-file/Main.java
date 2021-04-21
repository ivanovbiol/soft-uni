import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    private static final String PRINT_TEMPLATE = "%s ";

    public static void main(String[] args) throws IOException {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() throws IOException {
        // The file path should be customised from every user of the program
        // depending on the file location
        String filePath = "C:\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            int oneByte = readCharacter(fileInputStream);

            while (oneByte >= 0) {
                System.out.printf(PRINT_TEMPLATE, Integer.toBinaryString(oneByte));
                oneByte = readCharacter(fileInputStream);
            }
            fileInputStream.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static int readCharacter(FileInputStream fileInputStream) throws IOException {
        return fileInputStream.read();
    }
}