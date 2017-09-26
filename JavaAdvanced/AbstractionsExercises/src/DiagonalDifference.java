import java.util.Scanner;
public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dimensions][dimensions];

        matrix = fillMatrix(matrix, scanner);
        int difference = CalculateDiagonalDifference(matrix);

        System.out.println(difference);
    }

    private static int CalculateDiagonalDifference(int[][] matrix) {

        int diagonalA = CalculatePrimaryDiagonal(matrix);
        int diagonalB = CalculateSecondatyDiagonal(matrix);

        return Math.abs(diagonalA - diagonalB);
    }

    private static int CalculateSecondatyDiagonal(int[][] matrix) {
        int sum =0;
        int j = 0;
        for (int i = matrix.length-1; i >=0 ; i--) {
            sum += matrix[i][j];
            j++;
        }
        return sum;
    }

    private static int CalculatePrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i <matrix.length ; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }

    private static int[][] fillMatrix(int[][] matrix, Scanner scanner) {

        for (int i = 0; i <matrix.length ; i++) {
            String[] numbers = scanner.nextLine().split(" ");
            for (int j = 0; j <matrix[i].length ; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        return matrix;
    }
}
