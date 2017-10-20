import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitRoller {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long number = Long.parseLong(reader.readLine());
        int frozenIndex = Integer.parseInt(reader.readLine());
        int cycles = Integer.parseInt(reader.readLine());

        long frozenBitValue = (number >>frozenIndex) & 1L;
        for (int i = 0; i <cycles ; i++) {
            long firstBitValue = number & 1L;
            number >>= 1;
            if (frozenIndex!=0) {
                number = setBitValue(number, firstBitValue, 18);
            }

            long jumpBitValue = (number >> frozenIndex) & 1L;
            number = setBitValue(number, jumpBitValue, frozenIndex-1);
            number = setBitValue(number, frozenBitValue, frozenIndex);
        }
        System.out.println(number);
    }

    private static long setBitValue(long number, long bitValue, int index) {
        if (bitValue == 1){
            number |= 1<<index;
        } else {
            number &= ~(1<<index);
        }
        return number;
    }
}
