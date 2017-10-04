import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("<a\\s+([^>]+\\s+)?href\\s*=\\s*('([^']*)'|\"([^\"]*)|([^\\s>]+))[^>]*>");

        while(true){
            String text = scanner.nextLine();
            if(text.equals("END")){
                break;
            }
            sb.append(text);
        }
        Matcher match = pattern.matcher(sb);
        while (match.find( )){
            for (int i = 5; i >= 1; i--) {
                if(match.group(i) != null){
                    System.out.println(match.group(i) );
                    break;
                }
            }
        }

    }

}
