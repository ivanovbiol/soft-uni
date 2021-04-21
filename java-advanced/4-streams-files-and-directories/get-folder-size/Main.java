import java.io.File;

public class Main {

    private static final String PRINT_TEMPLATE = "Folder size: %d";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        // The file path should be customised from every user of the program
        // depending on the file location
        String pathName = "C:\\Exercises Resources";

        try {
            File file = new File(pathName);
            File[] files = file.listFiles();

            // int is enough, we do not need long in this task
            int size = 0;

            if (files != null) {
                for (File currentFile : files) {
                    if (!currentFile.isDirectory()) {
                        size += currentFile.length();
                    }
                }
            }

            System.out.printf(PRINT_TEMPLATE, size).println();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}