package override;

public class Main {

    public static void main(String[] args) {

        Shape rec = new Rectangle(2, 3);
        Shape circle = new Circle(5);
        System.out.println(rec.calculatePerimeter());
        System.out.println(rec.calculateArea());
        System.out.println(circle.calculatePerimeter());
        System.out.println(circle.calculateArea());
    }
}
