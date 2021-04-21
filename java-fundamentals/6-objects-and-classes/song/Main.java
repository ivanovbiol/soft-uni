import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Song> songsList = readInputSongs(scanner);

        String playlist = readRequiredPlaylist(scanner);

        System.out.println(getSortedSongs(songsList, playlist));
    }

    private static List<Song> readInputSongs(Scanner scanner) {
        List<Song> songsList = new ArrayList<>();

        int number = readIntNumber(scanner);

        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();

            String typeList = input.substring(0, input.indexOf("_"));
            String name = input.substring(input.indexOf("_") + 1, input.lastIndexOf("_"));
            String time = input.substring(input.lastIndexOf("_"));

            songsList.add(new Song(typeList, name, time));
        }

        return songsList;
    }

    private static String readRequiredPlaylist(Scanner scanner) {
        return scanner.nextLine();
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String getSortedSongs(List<Song> songsList, String playlist) {
        StringBuilder stringBuilder = new StringBuilder();

        if (playlist.equals("all")) {
            songsList
                    .forEach(e -> stringBuilder
                            .append(e.getName())
                            .append(System.lineSeparator()));
        } else {
            songsList
                    .stream()
                    .filter(e -> e.getTypeList().equals(playlist))
                    .forEach(e -> stringBuilder
                            .append(e.getName())
                            .append(System.lineSeparator()));
        }

        return stringBuilder.toString().trim();
    }
}
