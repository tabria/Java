import java.util.Scanner;
public class GameOfNames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n =Integer.parseInt(scanner.nextLine());

        String bestPlayer ="";
        int bestPlayerScore = Integer.MIN_VALUE;

        for (int i = 0; i <n ; i++) {
            String playerName = scanner.nextLine();
            int initialScore = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j <playerName.length() ; j++) {
                if (playerName.charAt(j) % 2 == 0) {
                    initialScore += playerName.charAt(j);
                } else {
                    initialScore -= playerName.charAt(j);
                }
            }

            if (initialScore > bestPlayerScore) {
                bestPlayerScore = initialScore;
                bestPlayer = playerName;
            }

        }

        System.out.printf("The winner is %s - %d points%n", bestPlayer, bestPlayerScore);
    }

}
