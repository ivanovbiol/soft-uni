public class Box {

    private static final String INVALID_WIDTH_MESSAGE = "Width cannot be zero or negative.";
    private static final String INVALID_LENGTH_MESSAGE = "Length cannot be zero or negative.";
    private static final String INVALID_HEIGHT_MESSAGE = "Height cannot be zero or negative.";

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    // Getters
    private double getLength() {
        return this.length;
    }
    private double getWidth() {
        return this.width;
    }
    private double getHeight() {
        return this.height;
    }

    // Setters
    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
        this.length = length;
    }
    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException(INVALID_WIDTH_MESSAGE);
        }
        this.width = width;
    }
    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException(INVALID_HEIGHT_MESSAGE);
        }
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return (2 * this.getLength() * this.getWidth()) + (2 * this.getLength() * this.getHeight())
                + (2 * this.getWidth() * this.getHeight());
    }

    public double calculateLateralSurfaceArea() {
        return (2 * this.getLength() * this.getHeight()) + (2 * this.getWidth() * this.getHeight());
    }

    public double calculateVolume() {
        return this.getHeight() * this.getWidth() * this.getLength();
    }
}
