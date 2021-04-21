import java.util.Scanner;

public class Main {

    private static final String EDIT_COMMAND = "Edit";
    private static final String CHANGE_AUTHOR_COMMAND = "ChangeAuthor";
    private static final String RENAME_COMMAND = "Rename";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Article article = readArticle(scanner);

        System.out.println(executeCommandsAndReturnResult(scanner, article));
    }

    private static Article readArticle(Scanner scanner) {
        String[] input = scanner.nextLine().split(",\\s+");

        String title = input[0];
        String content = input[1];
        String author = input[2];

        return new Article(title, content, author);
    }

    private static String executeCommandsAndReturnResult(Scanner scanner, Article article) {
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            String[] nextLine = scanner.nextLine().split(": ");
            String command = nextLine[0];

            switch (command) {
                case EDIT_COMMAND:
                    String content = nextLine[1];
                    article.edit(content);
                    break;
                case CHANGE_AUTHOR_COMMAND:
                    String author = nextLine[1];
                    article.changeAuthor(author);
                    break;
                case RENAME_COMMAND:
                    String title = nextLine[1];
                    article.rename(title);
                    break;
            }
        }
        return article.toString();
    }
}