import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
public class BasicStackOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] actions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> stack = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <actions[0] - actions[1] ; i++) {
            int currentNumber = numbers[i];
            min = currentNumber < min ? currentNumber : min;
            stack.push(currentNumber);
        }

        boolean exist = stack.contains(actions[2]);
        if (exist){
            System.out.println(true);
        } else {
            min = min == Integer.MAX_VALUE ? 0 : min;
            System.out.println(min);
        }


    }


}
