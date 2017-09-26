import java.util.Scanner;
public class MatrixPalindrome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];

        matrix = fillMatrix(matrix);

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            for (String cell : rows) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

    }

    private static String[][] fillMatrix(String[][] matrix) {

        for (int i = 0; i <matrix.length ; i++) {
            int middle = i;
            for (int j = 0; j <matrix[0].length ; j++) {
                if (j>0) {
                    middle++;
                }
                char a = (char)(i+97);
                char b = (char)(middle+97);

                matrix[i][j] = new String(new char[]{a, b, a});
            }
        }

        return matrix;
    }


}
