import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTags {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true){
            String currentText = scanner.nextLine();
            if (currentText.equals("END")) {
                break;
            }
            Pattern pattern = Pattern.compile("(<.*?>)");
            Matcher matcher = pattern.matcher(currentText);

            while(matcher.find()){
                sb.append(matcher.group());
                sb.append("\n");
            }

        }

        System.out.println(sb.toString());
    }
}
