import java.util.Arrays;
import java.util.Scanner;
public class FindMissingNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        long[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToLong(Long::parseLong).toArray();

        sortNums(numbers, 0);
        //Arrays.sort(numbers);
        long missingNumber = getMissing(numbers);
        System.out.println(missingNumber);
    }

    private static long getMissing(long[] numbers) {
        long missing = 1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == missing) {
                missing++;
            } else {
                break;
            }
        }
        return missing;
    }

    private static void sortNums(long[] numbers, int index) {
        if (index + 1 > numbers.length-1){
            return;
        }
        int minIndex = index;
        for (int j = index+1; j <numbers.length ; j++) {
            long currentNumber = numbers[j];
            if (currentNumber < numbers[minIndex]){
                minIndex = j;
            }
        }
        if (minIndex != index){
            long temp = numbers[index];
            numbers[index] = numbers[minIndex];
            numbers[minIndex] = temp;
        }
        sortNums(numbers, index+1);

    }

}
