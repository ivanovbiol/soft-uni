import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() throws IOException {
        // The file paths should be customised from every user of the program
        // depending on the file location
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(inputFilePath);
            FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath);

            int currentByte = fileInputStream.read();

            while (currentByte != -1) {
                    if (currentByte == ' ' || currentByte == '\n') {
                        fileOutputStream.write(currentByte);
                    } else {
                        fileOutputStream
                                .write(String.valueOf(currentByte)
                                        .getBytes(StandardCharsets.UTF_8));
                    }

                currentByte = fileInputStream.read();
            }

            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}