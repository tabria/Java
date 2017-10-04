import java.util.Scanner;
public class TextFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banList = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i <banList.length ; i++) {
            String replacer = wordToDots(banList[i]);
            text = text.replace(banList[i], replacer);
        }
        System.out.println(text);

    }

    private static String wordToDots(String word) {
        for (int i = 0; i <word.length() ; i++) {
            word = word.replace(word.charAt(i), '*');
        }
        return word;
    }

}
