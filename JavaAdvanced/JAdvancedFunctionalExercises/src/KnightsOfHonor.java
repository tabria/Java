import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");

        Consumer<String> printNames = name -> System.out.println("Sir " + name);

        for (int i = 0; i <names.length ; i++) {
            printNames.accept(names[i]);
        }

    }

}
