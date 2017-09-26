import java.math.BigInteger;
import java.util.Scanner;
public class PascalTriangle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int height = Integer.parseInt(scanner.nextLine());

        BigInteger[][] triangle = new BigInteger[height][height];
        for (int i = 0; i <height ; i++) {


            triangle[i][0] = new BigInteger("1");
            triangle[i][i] = new BigInteger("1");
            if (i>1){
                for (int j = 1; j <i ; j++) {
                    BigInteger[] prevRow =  triangle[i-1];
                    BigInteger prevSum = prevRow[j].add(prevRow[j-1]);
                    triangle[i][j] = prevSum;
                }
            }
        }

        for (int i = 0; i <triangle.length ; i++) {
            for (int j = 0; j <triangle[i].length ; j++) {
                if (triangle[i][j] != null){
                    System.out.print(triangle[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

}
