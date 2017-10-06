import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaximumElement {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int commands = Integer.parseInt(br.readLine());
        for (int i = 0; i <commands ; i++) {
            int[] actions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int act = actions[0];
            if (act == 1) {
                int num = actions[1];
                stack.push(num);
                if (queue.isEmpty() || queue.peek() <= num){
                    queue.push(num);
                } else {
                    queue.addLast(num);
                }
            } else if (act == 2 && !stack.isEmpty()){
                int a = stack.peek();
                queue.remove(a);
                stack.pop();
            }  else if (act == 3){
                System.out.println(queue.peek());

            }

        }


    }

}
