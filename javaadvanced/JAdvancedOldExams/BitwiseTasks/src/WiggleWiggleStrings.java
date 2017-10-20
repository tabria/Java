import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class WiggleWiggleStrings {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers  = reader.readLine().split("\\s+");

        for (int i = 0; i <numbers.length ; i+=2) {
            BigInteger num1 = new BigInteger(numbers[i]);
            BigInteger num2 = new BigInteger(numbers[i+1]);
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            sb1.append(num1.toString(2));
            sb2.append(num2.toString(2));

            fillTo64(sb1);
            fillTo64(sb2);

            for (int j = 0; j <sb1.length() ; j++) {
                if ( (j % 2==0) && (sb1.charAt(j) != sb2.charAt(j)) ){
                    char temp = sb1.charAt(j);
                    sb1.setCharAt(j, sb2.charAt(j));
                    sb2.setCharAt(j, temp);
                }

                reverseNumber(sb1, j);
                reverseNumber(sb2, j);
            }

            System.out.println(new BigInteger(sb1.toString(), 2) + " " + sb1.toString());
            System.out.println(new BigInteger(sb2.toString(), 2) + " " + sb2.toString());
        }
    }

    private static void reverseNumber(StringBuilder sb, int loopIndex) {
            char replacer = sb.charAt(loopIndex)=='1' ? '0' : '1';
            sb.setCharAt(loopIndex, replacer);
    }

    private static void fillTo64(StringBuilder sb) {
        while (sb.length()<63){
            sb.insert(0, 0);
        }
    }

}
