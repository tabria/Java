import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class WiggleWiggle {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers  = reader.readLine().split("\\s+");

        for (int k = 0; k <numbers.length ; k+=2) {
            BigInteger numberOne = new BigInteger(numbers[k]);
            BigInteger numberTwo = new BigInteger(numbers[k+1]);
            BigInteger one = new BigInteger("1");

            for (int i = 0; i <64 ; i+=2) {
                BigInteger biteOneValue = numberOne.shiftRight(i).and(one);
                BigInteger biteTwoValue = numberTwo.shiftRight(i).and(one);
                if (!biteOneValue.equals(biteTwoValue)) {
                    //numberOne = numberTwo.flipBit(i);
                    //numberTwo = numberTwo.flipBit(i);
                    numberOne = numberOne.xor(one.shiftLeft(i));
                    numberTwo = numberTwo.xor(one.shiftLeft(i));
                    //numberOne = switchBits(numberOne, biteOneValue, one, i);
                    //numberTwo = switchBits(numberTwo, biteTwoValue, one, i);
                }
            }

            numberOne = flipBitwise(numberOne, one);
            numberTwo = flipBitwise(numberTwo, one);

            System.out.println(numberOne.toString() + " " + numberOne.toString(2));
            System.out.println(numberTwo.toString() + " " + numberTwo.toString(2));
        }

    }

    private static BigInteger flipBitwise(BigInteger numberToFlip, BigInteger one) {
        for (int i = 0; i <63 ; i++) {
            //numberToFlip = numberToFlip.flipBit(i);
            //BigInteger biteToFlipValue = numberToFlip.shiftRight(i).and(one);
            //numberToFlip = switchBits(numberToFlip, biteToFlipValue, one, i);
            numberToFlip = numberToFlip.xor(one.shiftLeft(i));
        }
        return numberToFlip;
    }

//    private static BigInteger switchBits(BigInteger number, BigInteger biteValue, BigInteger one, int i ) {
//        if (biteValue.equals(one)){
//            //equals 0
//            return  number = number.xor(one.shiftLeft(i));
//        } else {
//            //equals 1
//            return number = number.xor(one.shiftLeft(i));
//        }
//    }
}
