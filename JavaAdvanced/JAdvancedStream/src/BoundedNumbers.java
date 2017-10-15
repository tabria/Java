import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BoundedNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> bound = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::valueOf).filter(x -> Collections.min(bound) <= x && x<=Collections.max(bound)).collect(Collectors.toList());

        numbers.stream().forEach(x -> System.out.print(x + " "));

    }

}
