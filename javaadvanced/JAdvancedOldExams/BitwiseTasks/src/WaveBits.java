import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.channels.Channels;

public class WaveBits {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger number = new BigInteger(reader.readLine());
        BigInteger one = new BigInteger("1");
        BigInteger zero = new BigInteger("0");
        int currentSequenceLength = 1;
        int maxSequenceLength = 0;
        int maxSequenceIndex = 0;

        String av = number.toString(2);

        for (int i = 0; i <=61 ; i++) {
            boolean isFirstBiteWave = number.shiftRight(i).and(one).equals(one);
            boolean isSecondBiteWave = number.shiftRight(i+1).and(one).equals(zero);
            boolean isThirdBiteWave = number.shiftRight(i+2).and(one).equals(one);

            if (isFirstBiteWave && isSecondBiteWave && isThirdBiteWave){
                currentSequenceLength +=2;
                if (currentSequenceLength > maxSequenceLength){
                    maxSequenceLength = currentSequenceLength;
                    maxSequenceIndex = i + 2;
                }
                i++;
            } else {
                currentSequenceLength = 1;
            }
        }

        int bestSequenceEndIndex = maxSequenceIndex - maxSequenceLength + 1;
        BigInteger outputNumber = new BigInteger("0");

        for (int i = 63; i >= 0; i--)
        {
            boolean inShouldBeDeletedRange = i <= maxSequenceIndex && i >= bestSequenceEndIndex;
            if (inShouldBeDeletedRange)
            {
                outputNumber = outputNumber.shiftRight(1);
            }
            else
            {
                BigInteger currentBit = number.and(new BigInteger("1").shiftLeft(i));
                outputNumber = outputNumber.or(currentBit);
            }
        }

        if (maxSequenceLength == 0)
        {
            System.out.println("No waves found!");
        }
        else
        {
            System.out.println(outputNumber);
        }

//        if (maxSequenceLength > 0){
//            StringBuilder sb = new StringBuilder();
//            String num = number.toString(2);
//            int startIndexRemove = num.length()-1 - maxSequenceIndex;
//            int endIndexRemove = startIndexRemove + maxSequenceLength-1;
//            for (int i = 0; i < num.length() ; i++) {
//                char a = num.charAt(i);
//                if (i < startIndexRemove || i> endIndexRemove){
//                    sb.append(num.charAt(i));
//                }
//            }
//            if (sb.length()>0){
//                System.out.println(new BigInteger(sb.toString(), 2));
//            } else {
//                System.out.println(0);
//            }
//        } else {
//            System.out.println("No waves found!");
//        }
    }

}
