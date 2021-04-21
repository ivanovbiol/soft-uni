import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() throws IOException {
        List<Character> forbiddenCharactersList = addForbiddenCharactersToStaticList();

        // The file paths should be customised from every user of the program
        // depending on the file location
        String inputFilePath = "C:\\input.txt";
        String outputFilePath = "C:\\output.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(inputFilePath);
            FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath);

            Scanner scanner = new Scanner(fileInputStream);

            while (scanner.hasNext()) {
                String lineOfText = scanner.nextLine();

                for (int index = 0; index < lineOfText.length(); index++) {
                    char currentCharacter = lineOfText.charAt(index);

                    if (isValidCharacter(currentCharacter, forbiddenCharactersList)) {
                        fileOutputStream.write(currentCharacter);
                    }
                }

                fileOutputStream.write(new byte[] {'\r', '\n'});
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static List<Character> addForbiddenCharactersToStaticList() {
        return List.of(',', '.', '!', '?');
    }

    private static boolean isValidCharacter(char currentCharacter,
            List<Character> forbiddenCharactersList) {
        // On my system the first character which is being read is &#65279 (U+FEFF) - Zero Width No-Break Space,
        // so i have to check and exclude it as well
        return !forbiddenCharactersList.contains(currentCharacter) && currentCharacter != 65279;
    }
}