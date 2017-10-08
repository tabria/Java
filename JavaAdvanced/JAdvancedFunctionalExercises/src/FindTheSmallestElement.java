import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class FindTheSmallestElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String value: input) {
            numbers.add(Integer.parseInt(value));
        }
        Function<List<Integer>, Integer> smallest = element -> element.lastIndexOf(element.stream().min(Comparator.comparing(i -> i)).get());
        System.out.println(smallest.apply(numbers));

    }

}
