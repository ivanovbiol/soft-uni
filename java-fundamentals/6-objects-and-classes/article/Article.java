public class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author) {
        this.setTitle(title);
        this.setContent(content);
        this.setAuthor(author);
    }

    private String getTitle() {
        return this.title;
    }

    private String getContent() {
        return this.content;
    }

    private String getAuthor() {
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

    public void edit(String content) {
        this.setContent(content);
    }

    public void changeAuthor(String author) {
        this.setAuthor(author);
    }

    public void rename(String title) {
        this.setTitle(title);
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", this.getTitle(), this.getContent(), this.getAuthor());
    }
}
