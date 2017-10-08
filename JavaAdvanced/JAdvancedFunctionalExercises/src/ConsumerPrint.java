import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerPrint {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String> print = name -> System.out.println(name);

        for (int i = 0; i <names.length ; i++) {
            print.accept(names[i]);
        }

    }


}
