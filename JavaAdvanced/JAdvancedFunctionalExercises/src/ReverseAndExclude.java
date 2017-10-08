import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int num = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = new ArrayList<>();

        Arrays.stream(input).forEach(element -> numbers.add(0, Integer.parseInt(element)));
        numbers.removeIf(element -> element % num == 0);
        numbers.forEach(value -> System.out.print(value + " "));
    }
}
