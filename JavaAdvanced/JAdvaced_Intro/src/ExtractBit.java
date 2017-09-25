import java.util.Scanner;
public class ExtractBit {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int index = scanner.nextInt();

        int mask = number >> index;
        int result = mask & 1;
        System.out.println(result);

    }
}
