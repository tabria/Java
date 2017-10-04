import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTag {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("<a(.+?)>(.*?)<\\/a>", Pattern.DOTALL);
        while(true) {
            String text = scanner.nextLine();
            if (text.equals("END")){
                break;
            }
            sb.append(text);
            sb.append("\r\n");
        }
        String replacement = "[URL$1]$2[/URL]";
        Matcher matcher = pattern.matcher(sb);
        String result ="";
        result = matcher.replaceAll(replacement);

        System.out.println(result);
    }

}
