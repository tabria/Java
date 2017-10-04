import java.util.Scanner;
public class RecursiveFactorial {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(factorial(number));
    }

    private static int factorial(int number) {
        if ( number <= 1) {
            return 1;
        }
        return number * factorial(number -1);
    }
}
