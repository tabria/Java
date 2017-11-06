package override_class;

public class Rectangle {

    protected double height;
    private double length;

    public Rectangle(double height) {
        this.height = height;
    }
    public Rectangle(double height, double length) {
        this.height = height;
        this.length = length;
    }



    protected double area(){
        return this.height * this.length;
    }

}
