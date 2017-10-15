import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;
public class AverageOfDoubles {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> str  = Arrays.asList(scanner.nextLine().split(" "));

        OptionalDouble average = str.stream().filter(n -> !n.isEmpty()).mapToDouble(Double::parseDouble).average();
        if (average.isPresent()){
            System.out.printf("%.2f", average.getAsDouble());
        } else {
            System.out.println("No match");
        }

    }

}
