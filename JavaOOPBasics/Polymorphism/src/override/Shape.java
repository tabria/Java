package override;

public abstract class Shape {

    private double perimeter;
    private double area;

    public Shape() {
    }

    private void setPerimeter() {
        this.perimeter = this.calculatePerimeter();
    }

    private final double getPerimeter() {
        return perimeter;
    }

    private final double getArea() {
        return area;
    }

    private void setArea() {
        this.area = this.calculateArea();
    }

    protected abstract double calculatePerimeter();
    protected abstract double calculateArea();

}
