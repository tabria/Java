import java.math.BigInteger;
import java.util.Scanner;

public class Lab01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstStr = scanner.next("\\w+");
        String secondStr = scanner.next("\\w+");
        int firstInt = scanner.nextInt();
        int secondInt = scanner.nextInt();
        int thirdInt = scanner.nextInt();
        scanner.nextLine();
        String finalStr = scanner.nextLine();

        BigInteger sum = BigInteger.valueOf(firstInt)
                    .add(BigInteger.valueOf(secondInt))
                    .add(BigInteger.valueOf(thirdInt));

        System.out.printf("%s %s %s %d", firstStr, secondStr, finalStr, sum);
    }

}
