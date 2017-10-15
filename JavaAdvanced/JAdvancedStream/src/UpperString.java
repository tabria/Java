import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class UpperString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> strList = Arrays.asList(scanner.nextLine().split(" "));
        strList.stream().map(s ->s.toUpperCase()).forEach(s-> System.out.print(s + " "));

    }
}
