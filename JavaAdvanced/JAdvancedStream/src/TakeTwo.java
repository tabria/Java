
import java.util.*;

public class TakeTwo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> strList = Arrays.asList(scanner.nextLine().split("\\s+"));
        List<Integer> intList = new ArrayList<>();
        for (String s:strList) {
            intList.add(Integer.valueOf(s));
        }

        intList.stream().filter(i -> 10<= i && i<=20).distinct().limit(2).forEach(i -> System.out.print(i + " "));

    }

}
