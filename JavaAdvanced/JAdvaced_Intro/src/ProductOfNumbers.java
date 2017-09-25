import java.math.BigInteger;
import java.util.Scanner;
public class ProductOfNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startRange = scanner.nextInt();
        int endRange = scanner.nextInt();

        BigInteger product = BigInteger.valueOf(startRange);
        int currentNumber = startRange;
        do {

            currentNumber++;
            product = product.multiply(BigInteger.valueOf(currentNumber));

        }while(currentNumber < endRange);


        System.out.printf("product[%d..%d] = %d", startRange, endRange, product);
    }

}
