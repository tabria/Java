
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer[] num = new Integer[numbers.length];
        for (int i = 0; i <numbers.length ; i++) {
            num[i] = numbers[i];
        }

        Function<Integer[], Integer> customMin = nums -> Collections.min(Arrays.asList(nums));

        System.out.println(customMin.apply(num));
    }

}
