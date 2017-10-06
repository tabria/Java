import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;
public class HotPotato {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] player = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        Deque<String> players = new ArrayDeque<>();
        for (int i = 0; i <player.length ; i++) {
            players.offer(player[i]);
        }


        while (players.size() > 1){
            for (int i = 1; i <n ; i++) {
                String element = players.poll();
               players.offer(element);
            }
            System.out.println("Removed " + players.poll());
        }
        System.out.println("Last is " + players.poll());


    }

}
