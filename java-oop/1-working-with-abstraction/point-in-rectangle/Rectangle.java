public class Rectangle {

    private static final String TRUE_MESSAGE = "true";
    private static final String FALSE_MESSAGE = "false";

    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.setBottomLeft(bottomLeft);
        this.setTopRight(topRight);
    }

    // Getters
    private Point getBottomLeft() {
        return this.bottomLeft;
    }
    private Point getTopRight() {
        return this.topRight;
    }

    // Setters
    private void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }
    private void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    public String contains(Point point) {
        return this.getBottomLeft().isLessOrEqual(point) &&
                this.getTopRight().isGreaterOrEqual(point) ?
                TRUE_MESSAGE : FALSE_MESSAGE;
    }
}
