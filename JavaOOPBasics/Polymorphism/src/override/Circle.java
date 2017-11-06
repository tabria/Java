package override;

public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    private final double getRadius() {
        return this.radius;
    }

    @Override
    protected double calculatePerimeter() {
        return 2*(getRadius() * 3.14) ;
    }

    @Override
    protected double calculateArea() {
        return getRadius() * getRadius() * 3.14;
    }
}
