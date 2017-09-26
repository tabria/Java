import java.util.Scanner;
public class SquaresInMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        Character[][] matrix = new Character[rows][cols];
        matrix = fillMatrix(matrix, scanner);
        int result = countEqualCells(matrix);
        System.out.println(result);

    }

    private static int countEqualCells(Character[][] matrix) {
        
        int result = 0;

        for (int i = 0; i <matrix.length-1 ; i++) {
            for (int j = 0; j <matrix[i].length-1 ; j++) {
                Character mainChar = matrix[i][j];
                if ((mainChar == matrix[i][j+1]) && (mainChar == matrix[i+1][j]) && (mainChar == matrix[i+1][j+1]) ){
                    result++;
                }
            }
        }
        
        return result;
    }

    private static Character[][] fillMatrix(Character[][] matrix, Scanner scanner) {

        for (int i = 0; i <matrix.length ; i++) {
            String[] values = scanner.nextLine().split(" ");
            for (int j = 0; j <matrix[i].length ; j++) {
                matrix[i][j] = values[j].charAt(0);
            }
        }

        return matrix;
    }

}
