import java.util.HashSet;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ListOfPredicates {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");

        HashSet<Integer> sequence = new HashSet<>();
        for (String value : input) {
            sequence.add(Integer.parseInt(value));
        }



        BiPredicate<Integer, Integer> isDivisible = (x, y) -> x % y == 0;
        for (int i = 1; i <=n ; i++) {
            boolean found = false;
            for (Integer seq: sequence) {
                if (!isDivisible.test(i, seq)){
                    found = true;
                    break;
                }
            }
            if (!found){
                System.out.print(i+ " ");
            }
        }
    }
}
