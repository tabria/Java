import java.util.Scanner;
public class CalculateExpression {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();


        double aPower = Math.pow(a, 2);
        double bPower = Math.pow(b, 2);
        double cPower = Math.pow(c, 3);
        double cSqrt = Math.sqrt(c);

        double f1 = Math.pow((aPower+bPower)/(aPower - bPower), (a+b+c)/cSqrt);
        double f2 = Math.pow(aPower + bPower - cPower, a-b);
        double avg = Math.abs( ((a+b+c)/3) - ((f1+f2)/2) );

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, avg);

    }

}
