import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BigDecimal sideA = scanner.nextBigDecimal();
        BigDecimal sideB = scanner.nextBigDecimal();

        BigDecimal area = sideA.multiply(sideB);

        System.out.printf("%.2f", area);

    }

}
