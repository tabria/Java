import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
public class MinEvenNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Optional<Double> optD = Arrays.stream(scanner.nextLine().split(" "))
                .filter(n-> !n.isEmpty())
                .map(Double::valueOf)
                .filter(n ->n %2 ==0)
                .min(Double::compare);
        if(optD.isPresent()){
            System.out.printf("%.2f",optD.get());
        } else {
            System.out.println("No match");
        }

    }

}
