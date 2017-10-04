import java.util.Arrays;
import java.util.Scanner;
public class Sorting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] text = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //selection sort

        for (int i = 0; i < text.length ; i++) {
            int min = i;
            for (int j = i; j <text.length ; j++) {
                if (text[min] > text[j]){
                    min = j;
                }
            }
            swap(text, min, i);
        }


        //bubble sort
        boolean swaped = true;
        do {
            swaped = false;
            for (int i = 0; i <text.length-1 ; i++) {
                if (text[i] > text[i+1]){
                    swap(text, i+1, i);
                    swaped = true;
                }
            }
        }while(swaped);

        for (int i = 0; i <text.length ; i++) {
            System.out.print(text[i] + " ");
        }

    }

    private static void swap(int[] text, int min, int index) {
        int temp = text[index];
        text[index] = text[min];
        text[min] = temp;

    }

}
