import java.util.Scanner;
public class SumMatrixElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] matrix = fillMatrix(scanner);
        long sum = sumMatrixElements(matrix);
        System.out.println(sum);
    }

    private static long sumMatrixElements(int[][] matrix) {
        long sum=0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static int[][] fillMatrix(Scanner scanner) {
        String[] rowCols = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(rowCols[0]);
        int cols = Integer.parseInt(rowCols[1]);

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i <matrix.length ; i++) {
            String[] numbersStr = scanner.nextLine().split(", ");
            for (int j = 0; j <matrix[i].length ; j++) {
                matrix[i][j] = Integer.parseInt(numbersStr[j]);
            }
        }
        printMatrixDimentions(rows, cols);

        return matrix;
    }

    private static void printMatrixDimentions(int rows, int cols) {
        System.out.println(rows);
        System.out.println(cols);
    }
}
