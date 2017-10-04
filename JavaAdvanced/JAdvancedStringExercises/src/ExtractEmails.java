import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?:^|\\s)([a-zA-Z\\d][\\w\\d.-]+?)@([A-Za-z-]+)+\\.(\\.*[A-Za-z-]+)+");

        while (true){
            String text = scanner.nextLine();
            if (text.equals("end")){
                break;
            }
            Matcher matcher = pattern.matcher(text);
            while(matcher.find()){
                System.out.println(matcher.group().trim());
            }
        }
    }

}
