import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class PlusRemove {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String[]> matrix = new ArrayList<>();
        List<int[]> positions = new ArrayList<>();

        while(true){
            String text = scanner.nextLine();
            if (text.equals("END")){
                break;
            }
            matrix.add(text.split(""));
        }

        for (int i = 0; i <matrix.size() ; i++) {
            for (int j = 0; j <matrix.get(i).length ; j++) {
                String currentString = String.valueOf(matrix.get(i)[j]).toLowerCase();
                try {
                    String leftString = String.valueOf(matrix.get(i+1)[j-1]).toLowerCase();
                    String lowerString = String.valueOf(matrix.get(i+2)[j]).toLowerCase();
                    String rightString = String.valueOf(matrix.get(i+1)[j+1]).toLowerCase();
                    String middleString = String.valueOf(matrix.get(i+1)[j]).toLowerCase();
                    if (leftString.equals(currentString) && lowerString.equals(currentString) &&
                            rightString.equals(currentString) && middleString.equals(currentString)) {
                            int[] pos = new int[] {i, j};
                            positions.add(pos);
                    }
                } catch (Exception e){
                }
            }
        }

        for (int i = 0; i <positions.size() ; i++) {
                int indexI = positions.get(i)[0];
                int indexJ = positions.get(i)[1];
                matrix.get(indexI)[indexJ] = "";
                matrix.get(indexI+1)[indexJ-1] = "";
                matrix.get(indexI+2)[indexJ] = "";
                matrix.get(indexI+1)[indexJ+1] = "";
                matrix.get(indexI+1)[indexJ] = "";
        }

        for (int i = 0; i <matrix.size() ; i++) {
            for (int j = 0; j <matrix.get(i).length ; j++) {
                System.out.print(matrix.get(i)[j]);
            }
            System.out.println();
        }
    }

}
