import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> removedStrings = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("([,_])([A-Za-z]+)([0-9])");

        while(true){
            String text = br.readLine();
            for ( String inText: removedStrings.keySet()) {
                if (text.contains(inText)){
                    text = text.replaceAll(inText, removedStrings.get(inText));
                }
            }
            if("Ascend".equalsIgnoreCase(text)){
                break;
            }
            Matcher matcher = pattern.matcher(text);
            while(matcher.find()){
                text = decodeMatch(text, matcher, removedStrings);
            }
            System.out.println(text);
        }
    }

    private static String decodeMatch(String text, Matcher matcher, Map<String, String> removedStrings) {
        String replace = "";
        int operator = "_".equals(matcher.group(1)) ? -1 : 1;
        int digit = Integer.parseInt(matcher.group(3))*operator;
        for (int i = 0; i <matcher.group(2).length() ; i++) {
            int newChar = matcher.group(2).charAt(i) + digit;
            replace += Character.toString((char) newChar);
        }
        removedStrings.putIfAbsent(matcher.group(), replace);
        return text.replaceAll(matcher.group(), replace);
    }

}
