import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");
        boolean validUsername = false;
        StringBuilder sb = new StringBuilder();

        while(true) {
            String text = scanner.nextLine();
            if (text.equals("END")){
                break;
            }
            Matcher match = pattern.matcher(text);

            if(match.find()) {
                sb.append("valid\n");
                validUsername = true;
            } else {
                sb.append("invalid\n");
            }

        }
        if (validUsername){
            System.out.println(sb.toString());
        }
    }
}
