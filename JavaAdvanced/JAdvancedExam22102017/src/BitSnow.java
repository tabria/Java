import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BitSnow {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long[] numbers = Arrays.stream(reader.readLine().split(", ")).mapToLong(Long::parseLong).toArray();

        for (int i = 0; i <16 ; i++) {
            int k = 0;
            for (int j = 0; j <numbers.length-1 ; j++) {
                long currentBitValue = (numbers[j]>>i)&1;
                if (currentBitValue != 0 && numbers.length-1-k>j) {
                    long nextNumberBitValue = 0L;
                    if(j <numbers.length-1){
                        if (k >= numbers.length-1){
                            break;
                        }
                        nextNumberBitValue = (numbers[numbers.length-1-k]>>i)&1;
                        if (nextNumberBitValue == 1){
                            k++;
                            j--;
                        }
                    }
                    if (j<numbers.length-1 & nextNumberBitValue == 0){
                        numbers[j]&=~(1 << i);
                        numbers[numbers.length-1-k] |= 1<<i;
                        k++;
                    }
                }
            }
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i <numbers.length ; i++) {
            if(i>0){
                output.append(", ");
            }
            output.append(numbers[i]);
        }
        System.out.println(output.toString());
    }

}
