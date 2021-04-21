import java.io.File;
import java.nio.file.InvalidPathException;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    private static final String PRINT_TEMPLATE = "%d folders";

    public static void main(String[] args) throws InvalidPathException {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() throws InvalidPathException {
        // The file path should be customised from every user of the program
        // depending on the file location
        String pathName = "C:\\Files-and-Streams";

        try {
            File file = new File(pathName);
            Queue<File> fileQueue = new ArrayDeque<>();

            fileQueue.offer(file);
            int counter = 0;

            while (!fileQueue.isEmpty()) {
                File currentFile = fileQueue.poll();

                System.out.println(currentFile.getName());
                counter++;

                File[] filesArray = currentFile.listFiles();

                for (File innerFile : filesArray) {
                    if (innerFile.isDirectory()) {
                        fileQueue.offer(innerFile);
                    }
                }
            }

            System.out.printf(PRINT_TEMPLATE, counter);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}