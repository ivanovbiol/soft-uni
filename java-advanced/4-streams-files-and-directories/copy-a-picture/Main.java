import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {

    private static final int BYTE_ARRAY_SIZE = 1024;

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        // The file paths should be customised from every user of the program
        // depending on the file location
        String inputPathName = "C:\\picture.jpg";
        String outputPathName = "C:\\picture-copy.jpg";

        try {
            FileInputStream fileInputStream = new FileInputStream(inputPathName);
            FileOutputStream fileOutputStream = new FileOutputStream(outputPathName);

            byte[] byteBuffer = new byte[BYTE_ARRAY_SIZE];

            while (fileInputStream.read(byteBuffer) != -1) {
                fileOutputStream.write(byteBuffer);
            }

            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}