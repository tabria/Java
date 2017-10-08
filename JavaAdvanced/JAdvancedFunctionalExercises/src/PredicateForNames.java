import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int maxLength = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split(" ");

        Predicate<Integer> isInMaxLength = nameLength -> nameLength <= maxLength;

        for (String name: names) {
            if (isInMaxLength.test(name.length())){
                System.out.println(name);
            }
        }

    }

}
