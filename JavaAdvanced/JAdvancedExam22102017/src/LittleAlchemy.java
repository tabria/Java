import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        fillQueue(queue, reader);


        while(true){
            String[] actions = reader.readLine().split("\\s+");
            if ("Revision".equals(actions[0])){
                break;
            }
            String action = actions[1];
            if ("acid".equals(action)){
                applyAcid(queue, stack, actions);

            }
            if ("leak".equals(action)){
                applyAir(queue, stack, actions);

            }
        }
        StringBuilder outputStones = new StringBuilder();
        for (Integer stone:queue) {
            if (outputStones.length()!=0){
                outputStones.append(" ");
            }
            outputStones.append(queue.poll());
        }

        System.out.println(outputStones.toString());
        System.out.println(stack.size());
    }

    private static void applyAir(Deque<Integer> queue, Deque<Integer> stack, String[] actions) {
        int stoneValue = Integer.parseInt(actions[2]);
        if (stack.size()>0){
            stack.pop();
            queue.offer(stoneValue);
        }
    }

    private static void applyAcid(Deque<Integer> queue, Deque<Integer> stack, String[] actions) {
        int numberOfStones = Integer.parseInt(actions[2]);
        for (int i = 0; i <numberOfStones ; i++) {
            if (queue.size()>0) {
                int currentStone = queue.poll();
                currentStone -=1;
                if (currentStone <=0) {
                    stack.push(0);
                } else {
                    queue.offer(currentStone);
                }
            } else {
                break;
            }
        }
    }

    private static void fillQueue(Deque<Integer> queue, BufferedReader reader) throws IOException {
        String[] input = reader.readLine().split("\\s+");
        for (int i = 0; i <input.length ; i++) {
            queue.offer(Integer.parseInt(input[i]));
        }
    }
}
