import java.util.Scanner;
public class MatrixShfflung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];

        matrix = fillMatrix(matrix, scanner);

        swapMatrixElements(matrix, scanner);

    }

    private static void swapMatrixElements(String[][] matrix, Scanner scanner) {
        while(true){
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("END")){
                break;
            }

            if (command.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }

            String keyWord = command[0];
            int row1 = Integer.parseInt(command[1]);
            int row2 = Integer.parseInt(command[3]);
            int col1 = Integer.parseInt(command[2]);
            int col2 = Integer.parseInt(command[4]);

            boolean isCommand = checkCommand(keyWord, row1, row2, col1, col2, matrix);
            if (!isCommand){
                System.out.println("Invalid input!");
                continue;
            }

            String element = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = element;
            printMatrix(matrix);
        }

    }

    private static void printMatrix(String[][] matrix) {

        for (String[] rows : matrix) {
            for (String element : rows) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkCommand(String keyWord, int row1, int row2, int col1, int col2, String[][] matrix) {
        if (!keyWord.equals("swap")) {
            return false;
        }

        if ( (row1 > matrix.length-1) || (row1 < 0) || (row2 >matrix.length-1) || (row2 < 0) ){
            return false;
        }

        if ( (col1 > matrix[0].length-1) || (col1 < 0) || (col2 >matrix[0].length-1) || (col2 < 0) ){
            return false;
        }

        return true;
    }

    private static String[][] fillMatrix(String[][] matrix, Scanner scanner) {

        for (int i = 0; i <matrix.length ; i++) {
            String[] elements = scanner.nextLine().split(" ");
            for (int j = 0; j <matrix[i].length ; j++) {
                matrix[i][j] = elements[j];
            }
        }

        return matrix;
    }
}
