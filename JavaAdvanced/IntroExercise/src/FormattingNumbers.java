import java.util.Scanner;
public class FormattingNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        String aToBinary =Integer.toBinaryString(a).replace(' ', '0');
        System.out.print("|" + String.format("%-10X|", a)
                             + String.format("%010d|", Integer.parseInt(aToBinary))
                             + String.format("% 10.2f|", b)
                             + String.format("%-10.3f|", c));

    }

}
