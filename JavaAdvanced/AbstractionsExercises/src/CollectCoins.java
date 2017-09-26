import java.util.Scanner;
public class CollectCoins {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] board = new String[4][1];
        for (int i = 0; i <board.length ; i++) {
            board[i][0] = scanner.nextLine();
        }

        String moves = scanner.nextLine();
        int[] results = playGame(board, moves);

        printResult(results);

    }

    private static void printResult(int[] results) {
        System.out.println("Coins = " + results[0]);
        System.out.println("Walls = " + results[1]);
    }

    private static int[] playGame(String[][] board, String moves) {
        int[] results = new int[2];
        int[] startPositions = new int[] {0, 0};
        for (int i = 0; i <moves.length() ; i++) {
            Character currentMove = moves.charAt(i);
            switch(currentMove){
                case '^':
                    verticalMove(board, results, startPositions, "up");
                    break;
                case 'V':
                    verticalMove(board, results, startPositions, "down");
                    break;
                case '<':
                    horizontalMove(board, results, startPositions, "left");
                    break;
                case '>':
                    horizontalMove(board, results, startPositions, "right");
                    break;
                default:
                    break;
            }
        }

        return results;
    }

    private static void horizontalMove(String[][] board, int[] results, int[] startPositions, String horizontalMove) {
        int startJ = horizontalMove.equals("left") ? startPositions[1] - 1 : startPositions[1] + 1;
        int startI = startPositions[0];
        try{
            countCoins(board, results, startI, startJ);
        } catch (Exception e){
            results[1]++;
            startJ = startPositions[1];
        }
        startPositions[1] = startJ;
    }

    private static void verticalMove(String[][] board, int[] results, int[] startPositions, String vertMove) {
        int startI = vertMove.equals("down") ? startPositions[0] + 1 : startPositions[0] - 1;
        int startJ = startPositions[1];
        try{
            countCoins(board, results, startI, startJ);
        } catch (Exception e){
            results[1]++;
            startI = startPositions[0];
        }
        startPositions[0] = startI;
    }

    private static void countCoins(String[][] board, int[] results, int startI, int startJ) {
        String currentWord = board[startI][0];
        Character currentChar = currentWord.charAt(startJ);
        if (currentChar == '$') {
            results[0]++;
        }
    }

}
