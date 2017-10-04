import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("([A-Z][A-Za-z]*)[^A-Za-z0-9+]*([+]?[0-9]+[0-9\\- \\.\\/\\)\\(]*[0-9]+)");

        while(true){
            String line = scanner.nextLine();
            if (line.equals("END")){
                break;
            }
            sb.append(line);
        }
        Matcher matcher = pattern.matcher(sb);
        StringBuilder sbResult = new StringBuilder();
        sbResult.append("<ol>");
        boolean isPhone = false;
        while(matcher.find()){
            isPhone = true;
            sbResult.append("<li><b>");
            sbResult.append(matcher.group(1));
            sbResult.append(":</b> ");
            getNumbers(matcher.group(2), sbResult, 0);
            sbResult.append("</li>");
        }
        if ( isPhone) {
            sbResult.append("</ol>");
            System.out.println(sbResult.toString());
        } else {
            System.out.println("<p>No matches!</p>");
        }
    }

    private static void getNumbers(String phone, StringBuilder sbResult, int index) {
        if(index > phone.length()-1){
            return;
        } else {
            char currentChar = phone.charAt(index);
            if (Character.isDigit(currentChar) || currentChar == '+'){
                sbResult.append(currentChar);
            }
            getNumbers(phone, sbResult,index+1);
        }
    }
}

