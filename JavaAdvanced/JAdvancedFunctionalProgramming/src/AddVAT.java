import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AddVAT {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] prices = scanner.nextLine().split(", ");

        Function<String, Double> parse = s -> Double.parseDouble(s);
        Function<Double, Double> addVAT = d-> d * 1.20;
        Consumer<Double> print = message -> System.out.println(String.format("%.2f", message).replace('.', ','));

        System.out.println("Prices with VAT:");
        for (String price : prices) {
            double currentPrice = parse.apply(price);
            print.accept(addVAT.apply(currentPrice));
        }
    }
}
