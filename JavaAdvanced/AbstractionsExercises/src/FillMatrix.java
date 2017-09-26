import java.util.Scanner;
public class FillMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int dimension = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[dimension][dimension];
        
        if (pattern.equals("A")) {
            matrix = fillMatrixAPattern(matrix);
        } else {
            matrix = fillMatrixBPattern(matrix);
        }
        
        printMatrix (matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int cell : rows ) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixBPattern(int[][] matrix) {
        int number = 1;
        int correction = 0;
        int currentCol = 0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                if (j==currentCol) {
                    if (j%2 == 0) {
                        matrix[i][j] = number;
                        number++;
                    } else {
                        matrix[i][j] = number;
                        number--;
                    }

                    if (i==matrix.length-1 && currentCol <matrix.length-1) {
                        i=-1;
                        currentCol++;
                        if (j%2 == 0){
                            number = number - 1 + matrix.length;
                        } else {
                            number = number + 1 +matrix.length;
                        }
                    }
                    break;
                }
            }
        }

        return matrix;
    }

    private static int[][] fillMatrixAPattern(int[][] matrix) {
        int number = 1;
        int currentCol = 0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                if (j==currentCol) {
                    matrix[i][j] = number;
                    number++;
                    if (i==matrix.length-1 && currentCol <matrix.length-1) {
                        i=-1;
                        currentCol++;
                    }
                    break;
                }
            }
        }
        
        return matrix;
    }

}
