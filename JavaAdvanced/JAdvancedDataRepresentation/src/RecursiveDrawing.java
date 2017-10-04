import java.util.Collections;
import java.util.Scanner;
public class RecursiveDrawing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        draw(number);

    }

    private static void draw(int number) {

        if (number == 0) {
            return;
        }
        System.out.println(String.join("", Collections.nCopies(number, "*")));

        draw(number-1);

        System.out.println(String.join("", Collections.nCopies(number, "#")));

    }

}
