public abstract class Shape implements Shapable{

    private double perimeter;
    private double area;

    public Shape() {
        this.setPerimeter(0);
        this.setArea(0);
    }

    //Getters
    protected double getPerimeter() {
        return this.perimeter;
    }
    protected double getArea() {
        return this.area;
    }

    // Setters
    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
    protected void setArea(double area) {
        this.area = area;
    }

    public void calculatePerimeter() {
    }

    @Override
    public void calculateArea() {
    }
}