package override_class;

public class Square extends Rectangle {

    public Square(double height) {
        super(height);
    }

    @Override
    protected double area() {
        return this.height * this.height ;
    }
}
