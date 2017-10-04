import java.util.Scanner;
public class UnicodeCharacters {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        for (char i : text.toCharArray()) {
            sb.append(String.format("\\u%04x", (int) i ));
        }
        System.out.println(sb.toString());
    }

}
