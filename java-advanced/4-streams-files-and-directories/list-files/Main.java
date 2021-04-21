import java.io.File;
import java.nio.file.InvalidPathException;
import java.util.Arrays;

public class Main {

    private static final String PRINT_TEMPLATE = "%s: %d";

    public static void main(String[] args) throws InvalidPathException {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() throws InvalidPathException {
        // The file path should be customised from every user of the program
        // depending on the file location
        String pathName = "C:\\Files-and-Streams";

        try {
            File file = new File(pathName);

            if (file.exists()) {
                File[] filesArray = file.listFiles();

                if (filesArray != null) {
                    Arrays
                            .stream(filesArray)
                            .filter(fileFromArray -> !fileFromArray.isDirectory())
                            .forEach(element ->
                                    System.out.printf(
                                            PRINT_TEMPLATE, element.getName(), element.length())
                                            .println());
                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}