import java.math.BigInteger;
import java.util.Scanner;
public class CombinationsCount {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        BigInteger nFactorial = getFactorial(n);
        BigInteger kFactorial = getFactorial(k);
        BigInteger difference = getFactorial(n-k);

        BigInteger result = nFactorial.divide( difference.multiply(kFactorial) );

        System.out.println(result);
    }

    private static BigInteger getFactorial(int number) {
        BigInteger sum = new BigInteger("1");
        sum = calculateFactorial(sum, number);
        return sum;

    }

    private static BigInteger calculateFactorial(BigInteger sum, int number) {
        if (number <=1){
            return sum;
        }
        sum = sum.multiply(BigInteger.valueOf(number));
        return calculateFactorial(sum, number-1);

    }

}
