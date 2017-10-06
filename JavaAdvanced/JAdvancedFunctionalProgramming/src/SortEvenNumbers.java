import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class SortEvenNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> parsedNums = new ArrayList<>();
        String[] numbers = scanner.nextLine().split(", ");

        Function<String, Integer> parse = s->Integer.parseInt(s);

        for (String element : numbers) {
            parsedNums.add(parse.apply(element));
        }

        parsedNums.removeIf(i-> i%2 != 0);
        printArray(parsedNums);
        System.out.println();
        parsedNums.sort((n, m) -> n.compareTo(m));
        printArray(parsedNums);

    }

    private static void printArray(List<Integer> parsedNums) {
        for (int i = 0; i <parsedNums.size() ; i++) {
            String spacer = i==0 ? "" : ", ";
            System.out.print(spacer + parsedNums.get(i));
        }
    }

}
