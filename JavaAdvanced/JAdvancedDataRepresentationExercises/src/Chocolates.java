import java.util.Arrays;
import java.util.Scanner;
public class Chocolates {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] packets = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int students = Integer.parseInt(scanner.nextLine());

        int diff = calculateMinDifference(packets, students);

        System.out.println("Min Difference is " + diff + ".");

    }

    private static int calculateMinDifference(int[] packets, int students) {
        sortArray(packets, 0);
        int min = Integer.MAX_VALUE;
        return calculateRecursive(packets, min, students, 0);
    }

    private static int calculateRecursive(int[] packets, int min, int students, int start) {
        int end = start + students;
        if (end > packets.length) {
            return min;
        } else {
            int diff = 0;
            for (int i = start; i < end - 1 ; i++) {
                int a = packets[i+1];
                int b = packets[i];
                diff += packets[i+1] - packets[i];
            }
            if (diff < min) {
                min = diff;
            }
           return calculateRecursive(packets, min, students, start+1);
        }
    }

    private static void sortArray(int[] packets, int index) {
        if (index > packets.length-2) {
            return;
        }
        int currentMinIndex = index;
        for (int i = index+1; i <packets.length ; i++) {
            if (packets[i]< packets[currentMinIndex]){
                currentMinIndex = i;
            }
        }
        if (currentMinIndex != index) {
            swapArray(index, currentMinIndex, packets);
        }
        sortArray(packets,index+1);
    }

    private static void swapArray(int index, int currentMinIndex, int[] packets) {
        int temp = packets[index];
        packets[index] = packets[currentMinIndex];
        packets[currentMinIndex]=temp;
    }

}
