import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CountUppercaseWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String text[] = scanner.nextLine().split(" ");

        Predicate<Character> isUpper = x-> Character.isUpperCase(x);
        Consumer<String> print = message -> System.out.println(message);

        int countUpper= 0;
        for (int i = 0; i <text.length ; i++) {
            if (isUpper.test(text[i].charAt(0))) {
                countUpper++;
                sb.append(text[i]);
                sb.append("\r\n");
            }
        }

        print.accept(String.valueOf(countUpper));
        print.accept(sb.toString());

    }
}
