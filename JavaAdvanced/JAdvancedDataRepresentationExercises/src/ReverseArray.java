import java.util.Arrays;
import java.util.Scanner;
public class ReverseArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers  = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        numbers = reverseArray(numbers, numbers.length-1, 0);

        printArray(numbers);

    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i <numbers.length ; i++) {
            System.out.print(numbers[i] + " ");
        }

    }

    private static int[] reverseArray(int[] numbers, int endIndex, int startIndex) {

        if(endIndex == (numbers.length/2)-1){
            return numbers;
        } else {
            int temp = numbers[startIndex];
            numbers[startIndex] = numbers[endIndex];
            numbers[endIndex] = temp;
            return reverseArray(numbers, endIndex-1, startIndex+1);
        }

    }


}
