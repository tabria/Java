import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterExpression {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern textDigit = Pattern.compile("([^0-9]*)(\\d+)");
        boolean isFirst = false;
        long sum = 0L;
        int operator = 1;
        String text = reader.readLine();

        Matcher match = textDigit.matcher(text);
        while(match.find()){
            if(!isFirst){
                sum += Integer.parseInt(match.group(2));
                isFirst = true;
            } else {
                int textLength = match.group(1).length();
                operator = textLength % 2 == 0 ? 1 : -1;
                sum += Integer.parseInt(match.group(2))*operator;
            }
        }
        System.out.println(sum);
    }

}
