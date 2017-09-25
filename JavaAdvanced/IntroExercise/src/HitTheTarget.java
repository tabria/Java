import java.util.Scanner;
public class HitTheTarget {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        for(int i =1; i<=20; i++){
            for (int k=1; k<=20; k++){
                if (i + k == a) {
                    System.out.println(i + " + " + k + " = " + a);
                }
                if (i-k == a) {
                    System.out.println(i + " - " + k + " = " + a);
                }
            }
        }
    }


}
