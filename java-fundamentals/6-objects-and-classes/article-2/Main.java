import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String TITLE_COMMAND = "title";
    private static final String CONTENT_COMMAND = "content";
    private static final String AUTHOR_COMMAND = "author";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Article> articles = readArticleList(scanner);

        System.out.println(filterArticlesAndReturn(scanner, articles));
    }

    private static List<Article> readArticleList(Scanner scanner) {
        List<Article> articles = new ArrayList<>();

        int number = Integer.parseInt(scanner.nextLine());

        while (number-- > 0) {
            String[] input = scanner.nextLine().split(",\\s+");

            String title = input[0];
            String content = input[1];
            String author = input[2];

            articles.add(new Article(title, content, author));
        }
        return articles;
    }

    private static String filterArticlesAndReturn(Scanner scanner, List<Article> articles) {
        String result = "";
        String filteringCriteria = scanner.nextLine();

        switch (filteringCriteria) {
            case TITLE_COMMAND:
                result = articles
                            .stream()
                            .sorted(Comparator.comparing(Article::getTitle))
                            .map(Article::toString)
                            .collect(Collectors.joining(System.lineSeparator()));
                break;
            case CONTENT_COMMAND:
                result = articles
                            .stream()
                            .sorted(Comparator.comparing(Article::getContent))
                            .map(Article::toString)
                            .collect(Collectors.joining(System.lineSeparator()));
                break;
            case AUTHOR_COMMAND:
                result = articles
                            .stream()
                            .sorted(Comparator.comparing(Article::getAuthor))
                            .map(Article::toString)
                            .collect(Collectors.joining(System.lineSeparator()));
                break;
        }
        return result;
    }
}
