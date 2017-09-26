import java.util.Scanner;
public class CalculateTriangleAreaMethod {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Double base = scanner.nextDouble();
        Double height = scanner.nextDouble();
        scanner.nextLine();

        double area = CalcArea(base, height);
        System.out.printf("Area = %.2f", area);
    }

    private static double CalcArea(Double base, Double height) {

        return (base * height )/2;
    }


}

