import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Searching {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int keyNumber = Integer.parseInt(br.readLine());

        int index = -1;

        //linear search;
        for (int i = 0; i < numbers.length ; i++) {
            if (numbers[i] == keyNumber){
                index = i;
            }
        }

        //binary search
        int start = 0;
        int end = numbers.length-1;
        while (start <= end) {

            int middle = (start + end)/2;
            if (numbers[middle] > keyNumber){
                end = middle - 1;
            } else if (numbers[middle] < keyNumber){
                start = middle + 1;
            } else {
                index = middle;
                break;
            }

        }

        System.out.println(index);
        
    }

}
