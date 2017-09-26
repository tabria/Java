import java.util.Scanner;

public class SequenceInMatrix {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        String[][] matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = scan.nextLine().split(" ");
        }

        int maxCount = 0;
        String maxString = "";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                int down = 0;
                String temp2 = matrix[i][j];
                for (int k = i; k < matrix.length-1; k++) {
                    if(matrix[k][j].equals(matrix[k+1][j])){
                        down++;
                        String spacer = temp2.isEmpty() ? "" : ", ";
                        temp2 += spacer + matrix[i][j];
                    } else {
                        break;
                    }
                }
                if(down > maxCount){
                    maxCount = down;
                    maxString = temp2;
                }

                int count3 = 0;
                String temp3 = matrix[i][j];
                for (int k = i; k < Math.min(matrix.length-1,matrix[i].length-1); k++) {
                    if(matrix[k][k].equals(matrix[k+1][k+1])){
                        count3++;
                        String spacer = temp2.isEmpty() ? "" : ", ";
                        temp3 += spacer + matrix[k][k];
                    } else {
                        break;
                    }
                }
                if(count3 > maxCount){
                    maxCount = count3;
                    maxString = temp3;
                }
            }
        }
        if(maxString.equals("")){
            maxString = matrix[0][0];
        }
        System.out.println(maxString);
    }
}