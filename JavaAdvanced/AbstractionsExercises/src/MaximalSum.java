import java.util.Scanner;
public class MaximalSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];
        matrix = fillMatrix(matrix, scanner);
        int[][] square = extractSquare(matrix);
        printSquare(square);
    }

    private static void printSquare(int[][] square) {
        for (int[] rows : square) {
            for ( int cel : rows) {
                System.out.print(cel + " ");
            }
            System.out.println();
        }
    }

    private static int[][] extractSquare(int[][] matrix) {
        int[][] square = new int[3][3];
        long sum = Integer.MIN_VALUE;
        for (int i = 0; i <matrix.length -2 ; i++) {
            for (int j = 0; j <matrix[i].length -2 ; j++) {
                long currentSum = calculateSum(matrix, i, j);
                if (currentSum > sum) {
                    sum = currentSum;
                    square = fillSquareMatrix(matrix, square, i, j);
                }
            }
        }
        
        System.out.println("Sum = " + sum);
        return square;
    }

    private static int[][] fillSquareMatrix(int[][] matrix, int[][] square, int i, int j) {

        for (int k = 0; k <square.length ; k++) {
            for (int l = 0; l <square[k].length ; l++) {
                square[k][l] = matrix[i+k][j+l];
            }
        }

        return square;
    }


    private static long calculateSum(int[][] matrix, int i, int j) {
        long calculateSum = 0;

        for (int k = 0; k <3 ; k++) {
            for (int l = 0; l <3 ; l++) {
                calculateSum += matrix[i+k][j+l];
            }
        }
        
        return calculateSum;
    }

    private static int[][] fillMatrix(int[][] matrix, Scanner scanner) {

        for (int i = 0; i <matrix.length ; i++) {
            String[] numbers= scanner.nextLine().split(" ");
            for (int j = 0; j <matrix[i].length ; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        return matrix;
    }

}
