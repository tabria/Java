import java.util.*;

public class BasicQueueOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] actions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i <actions[0] ; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i <actions[1] ; i++) {
            queue.poll();
        }

        if (queue.contains(actions[2])){
            System.out.println(true);
        } else {
            if (queue.size()>0) {
                System.out.println(Collections.min(queue));
            } else {
                System.out.println(0);
            }

        }
    }

}
