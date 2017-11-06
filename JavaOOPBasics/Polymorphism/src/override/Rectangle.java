package override;

public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    private final double getHeight() {
        return this.height;
    }

    private final double getWidth() {
        return this.width;
    }

    @Override
    protected double calculatePerimeter() {
        return 2*(getHeight() + getWidth());
    }

    @Override
    protected double calculateArea() {
        return this.getHeight()*this.getWidth();
    }
}
