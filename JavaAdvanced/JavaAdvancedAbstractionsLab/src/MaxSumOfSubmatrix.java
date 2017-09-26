import java.util.Scanner;
public class MaxSumOfSubmatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] rowsCols = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);
        int[][] matrix = fillMatrix(rows, cols, scanner);
        maximumSumSubmatrix(matrix);
    }

    private static void printSubmatrix(int[][] submatrix) {
        for (int i = 0; i <submatrix.length ; i++) {
            for (int j = 0; j <submatrix[i].length ; j++) {
                System.out.print(submatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void maximumSumSubmatrix(int[][] matrix) {
        int[][] submatrix = new int[2][2];
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i <matrix.length-1 ; i++) {
            for (int j = 0; j <matrix[i].length-1 ; j++) {
                int currentSum = matrix[i][j] + matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1];
                if (sum < currentSum) {
                    sum = currentSum;
                    submatrix = fillSubmatrix(submatrix, matrix, i, j);
                }
            }
        }
        printSubmatrix(submatrix);
        System.out.println(sum);
    }

    private static int[][] fillSubmatrix(int[][] submatrix, int[][] martix, int i, int j) {
        for (int k = 0; k <submatrix.length ; k++) {
            for (int l = 0; l <submatrix[k].length ; l++) {
                submatrix[k][l] = martix[i+k][j+l];
            }
        }

        return submatrix;
    }

    private static int[][] fillMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i <matrix.length ; i++) {
            String[] numbers = scanner.nextLine().split(", ");
            for (int j = 0; j <matrix[i].length ; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        return matrix;
    }

}
