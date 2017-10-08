import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FindEvensOrOdds {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] boundary = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String type = scanner.nextLine();



        printResult(boundary, type);

    }

    private static void printResult(int[] boundary, String type) {
        Predicate<Integer> isEven = number -> number % 2 == 0;
        Predicate<String> isTypeEven = sType -> sType.equalsIgnoreCase("even");
        Consumer<Integer> print = element -> System.out.print(element + " ");


        for (int i = boundary[0]; i <=boundary[1] ; i++) {
            if (isEven.test(i) && isTypeEven.test(type)){
                print.accept(i);
            } else if(!isEven.test(i) && !isTypeEven.test(type)){
                print.accept(i);
            }
        }

    }

}
