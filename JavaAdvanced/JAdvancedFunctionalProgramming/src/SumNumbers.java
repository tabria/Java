import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split(", ");

        Function<String, Integer> parse = s->Integer.parseInt(s);

        int count =text.length;
        int sum =0;
        for (int i = 0; i <text.length ; i++) {
            sum += parse.apply(text[i]);
        }

        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);


    }

}
