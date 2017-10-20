import java.util.Arrays;
import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] board = new String[8][8];
        int[] badMoves = new int[2];
        StringBuilder sb = new StringBuilder();

        fillBoard(board, scanner);
        int[] knightStartPos = Arrays.stream(scanner.nextLine().trim().split("")).mapToInt(Integer::parseInt).toArray();
        makeMove(board, sb, badMoves, knightStartPos, scanner);

        System.out.println("Pieces take: " + sb.toString());
        System.out.println("Invalid moves: " + badMoves[0]);
        System.out.println("Board out moves: " + badMoves[1]);

    }

    private static void makeMove(String[][] board, StringBuilder sb, int[] badMoves, int[] knightStartPos, Scanner scanner) {
        while(true){
            String[] knightMove= scanner.nextLine().split(" -> ");
            if ("END".equals(knightMove[0])){
                break;
            }

            int[] knightEndPosition = Arrays.stream(knightMove[1].trim().split("")).mapToInt(Integer::parseInt).toArray();
            boolean isMoveValid = moveValidation(knightStartPos, knightEndPosition, badMoves);
            if (isMoveValid){
                int endRow = knightEndPosition[0];
                int endCol = knightEndPosition[1];
                String currentPiece = board[endRow][endCol];
                board[endRow][endCol] = " ";
                if (Character.isLetter(currentPiece.charAt(0))){
                    String spacer = sb.length() > 0 ? ", " : "";
                    sb.append(spacer).append(currentPiece);
                }
                knightStartPos[0] = endRow;
                knightStartPos[1] = endCol;
            }
        }
    }

    private static boolean moveValidation(int[] knightStartPos, int[] knightEndPosition, int[] badMoves) {
        int rowDiff = Math.abs(knightEndPosition[0] - knightStartPos[0]);
        int colDiff =Math.abs(knightEndPosition[1] -knightStartPos[1]);
        if (rowDiff > 2 || colDiff >2 || rowDiff == 0 || colDiff == 0){
            badMoves[0] += 1;
            return false;
        }
        if ((rowDiff == 2 && colDiff>1) || (colDiff == 2 && rowDiff >1)){
            badMoves[0] += 1;
            return false;
        }
        if (knightEndPosition[1] > 7 || knightEndPosition[1] < 0 || knightEndPosition[0]> 7 || knightEndPosition[0] < 0){
            badMoves[1] +=1;
            return false;
        }
        return true;
    }

    private static void fillBoard(String[][] board, Scanner scanner) {
        for (int i = 0; i <8 ; i++) {
            String[] row = scanner.nextLine().split("\\|");
            for (int j = 0; j <row.length ; j++) {
                board[i][j] = row[j];
            }
        }
    }
}
