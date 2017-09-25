import java.math.BigInteger;
import java.util.Scanner;
public class TriangleArea {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BigInteger ax = scanner.nextBigInteger();
        BigInteger ay = scanner.nextBigInteger();
        BigInteger bx = scanner.nextBigInteger();
        BigInteger by = scanner.nextBigInteger();
        BigInteger cx = scanner.nextBigInteger();
        BigInteger cy = scanner.nextBigInteger();

        BigInteger axPart = ax.multiply(by.subtract(cy));
        BigInteger bxPart = bx.multiply(cy.subtract(ay));
        BigInteger cxPart = cx.multiply(ay.subtract(by));

        BigInteger area = ((axPart.add(bxPart).add(cxPart)).divide(BigInteger.valueOf(2))).abs();

        System.out.println(area);
    }

}
