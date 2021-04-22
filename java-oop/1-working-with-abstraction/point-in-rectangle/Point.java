public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    // Getters
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    // Setters
    private void setX(int x) {
        this.x = x;
    }
    private void setY(int y) {
        this.y = y;
    }

    public boolean isLessOrEqual(Point point) {
        return this.getX() <= point.getX() && this.getY() <= point.getY();
    }

    public boolean isGreaterOrEqual(Point point) {
        return this.getX() >= point.getX() && this.getY() >= point.getY();
    }
}
