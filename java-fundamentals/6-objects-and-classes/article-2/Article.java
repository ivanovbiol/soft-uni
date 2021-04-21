public class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author) {
        this.setTitle(title);
        this.setContent(content);
        this.setAuthor(author);
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getAuthor() {
        return this.author;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setContent(String content) {
        this.content = content;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", this.getTitle(), this.getContent(), this.getAuthor());
    }
}
