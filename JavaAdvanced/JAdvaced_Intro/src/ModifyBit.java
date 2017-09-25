import java.util.Scanner;
public class ModifyBit {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int index = scanner.nextInt();
        int bitValue = scanner.nextInt();

        int mask = number>>index;
        int bit = mask & 1;

        int result = number;

        if (bit == 1 && bitValue == 0) {
            mask = ~(1<<index);
            result = number & mask;
        } else if (bit == 0 && bitValue == 1){
            mask = 1<<index;
            result = number | mask;
        }

        System.out.println(result);

    }
}
