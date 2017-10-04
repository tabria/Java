import java.util.Arrays;
import java.util.Scanner;
public class BinarySearch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int keyNumber = Integer.parseInt(scanner.nextLine());
        int start = 0;
        int end = numbers.length-1;

         int result = binarySearch(numbers, keyNumber, start, end);
        System.out.println(result);

    }

    private static int binarySearch(int[] numbers, int keyNumber, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = start+ (end - start)/2;
        if(numbers[middle] > keyNumber) {
            end = middle - 1;
            return binarySearch(numbers, keyNumber, start, end);
        } else if(numbers[middle] < keyNumber){
            start = middle + 1;
            return binarySearch(numbers, keyNumber, start, end);
        } else {
            return middle;
        }
    }

}
