
import java.util.Scanner;

public class AVGogThree {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double firstDouble = scanner.nextDouble();
        double secondDouble = scanner.nextDouble();
        double thirdDouble = scanner.nextDouble();

        double avg = (firstDouble + secondDouble +thirdDouble)/3;

        System.out.printf("%.2f",avg);

    }

}
