import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ShuffleBits {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long numberOne = Long.parseLong(reader.readLine());
        long numberTwo = Long.parseLong(reader.readLine());
        int oneCount = Long.toBinaryString(numberOne).length();
        int twoCount = Long.toBinaryString(numberTwo).length();
        StringBuilder sb = new StringBuilder();

        if (numberOne >= numberTwo){
            for (int i = 0; i <oneCount ; i++) {
                long byteFirstNumber = (numberOne >> oneCount-1 - i)&1;
                long byteSecondNumber = (numberTwo >> oneCount-1 - i)&1;
                sb.append(byteFirstNumber).append(byteSecondNumber);
            }
        } else {
            int diff = twoCount%2==0 ? 2 : 1;
            for (int i = 0; i <twoCount ; i+=2) {

                sb.append((numberOne >> twoCount-(diff-1) - i)&1);
                sb.append((numberOne >> twoCount-diff - i)&1);
                sb.append((numberTwo >> twoCount-(diff-1) - i)&1);
                sb.append((numberTwo >> twoCount-diff - i)&1);
            }
        }
        System.out.println(new BigInteger(sb.toString(), 2));
    }

}
