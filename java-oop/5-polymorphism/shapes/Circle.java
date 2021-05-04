public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.setRadius(radius);
    }

    // Getters
    private double getRadius() {
        return this.radius;
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
    private void setRadius(double radius) {
        this.radius = radius;
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
        this.setPerimeter(Math.PI * (2 * this.getRadius()));
    }

    @Override
    public void calculateArea() {
        this.setArea(Math.PI * Math.pow(this.getRadius(), 2));
    }
}
