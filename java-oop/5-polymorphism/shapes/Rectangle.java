public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    // Getters
    private double getWidth() {
        return this.width;
    }
    private double getHeight() {
        return this.height;
    }
    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }
    @Override
    public double getArea() {
        return super.getArea();
    }


    // Setters
    private void setWidth(double width) {
        this.width = width;
    }
    private void setHeight(double height) {
        this.height = height;
    }
    @Override
    protected void setPerimeter(double perimeter) {
        super.setPerimeter(perimeter);
    }
    @Override
    protected void setArea(double area) {
        super.setArea(area);
    }

    @Override
    public void calculatePerimeter() {
        this.setPerimeter((2 * this.getWidth()) + (2 * this.getHeight()));
    }

    @Override
    public void calculateArea() {
        this.setArea(this.getWidth() * this.getHeight());
    }
}
