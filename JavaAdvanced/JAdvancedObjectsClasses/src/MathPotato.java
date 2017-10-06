import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
public class MathPotato {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] player = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        Deque<String> players = new ArrayDeque<>();
        for (int i = 0; i <player.length ; i++) {
            players.offer(player[i]);
        }

        int cycles = 0;
        while (players.size() > 1){
            cycles++;
            for (int i = 1; i <n ; i++) {
                String element = players.poll();
                players.offer(element);
            }
            if (isPrime(cycles)){
                System.out.println("Prime " + players.peek());
            } else {
                System.out.println("Removed " + players.poll());
            }
        }
        System.out.println("Last is " + players.poll());
    }

    private static boolean isPrime(int cycles) {
        if (cycles == 1){
            return false;
        }
        for (int i = 2; i <=Math.sqrt(cycles) ; i++) {
            if (cycles % i == 0) {
                return false;
            }
        }
        return true;
    }

}
