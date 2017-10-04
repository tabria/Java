import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(^[A-Z][a-z]+[ ][A-Z][a-z]+$)");

        while(true){
            String text = scanner.nextLine();
            if (text.equals("end")){
                break;
            }

            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                System.out.println(matcher.group());
            }
        }

    }

}
