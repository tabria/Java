import java.util.Arrays;
import java.util.Scanner;
public class Shockwave {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] roomDimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] room = new int[roomDimensions[0]][roomDimensions[1]];

        while(true){
            String coords = scanner.nextLine();
            if ("Here We Go".equalsIgnoreCase(coords)){
                break;
            }

            detectShockwaves(room, coords);
        }

        System.out.println(Arrays.deepToString(room).replace("], ", "\n")
                .replace("[", "")
                .replace("]", "")
                .replace(", ", " "));

    }

    private static void detectShockwaves(int[][] room, String coords) {
        int[] rawCoords = Arrays.stream(coords.split(" ")).mapToInt(Integer::parseInt).toArray();
        int startRow = rawCoords[0];
        int startCol = rawCoords[1];
        int endRow = rawCoords[2];
        int endCol = rawCoords[3];
        for (int i = startRow ; i <=endRow ; i++) {
            for (int j = startCol; j <=endCol ; j++) {
                room[i][j] += 1;
            }
        }

    }

}
