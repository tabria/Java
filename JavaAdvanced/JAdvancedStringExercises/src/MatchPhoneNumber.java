import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^(\\+359)([ -])[2]\\2\\d{3}\\2\\d{4}$");

        while(true){
            String text = scanner.nextLine();
            if (text.equals("end")){
                break;
            }
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()){
                System.out.println(matcher.group());
            }

        }

    }

}
