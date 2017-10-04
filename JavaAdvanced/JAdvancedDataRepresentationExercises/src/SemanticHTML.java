import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticHTML {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String patternRegex = "(<div[^>]+>)";
        String patternRegexInside ="(\\s*(class|id)\\s*=\\s*\"\\s*(main|header|nav|article|section|aside|footer)\\s*\"\\s*)";
        String patternRegexEnd ="(</div>\\s*<!--\\s*)(main|header|nav|article|section|aside|footer)(\\s*-->)";

        Pattern pattern = Pattern.compile(patternRegex);
        Pattern patternEnd = Pattern.compile(patternRegexEnd);
        Pattern patternInside = Pattern.compile(patternRegexInside);

        String replaceEnd = "</$2>";

        while(true) {
            String textLine = scanner.nextLine();
            if(textLine.equals("END")){
                break;
            }
            Matcher matcher = pattern.matcher(textLine);
            if(matcher.find()) {
                Matcher matcherInside = patternInside.matcher(textLine);
                if (matcherInside.find()) {
                    textLine = textLine.replaceAll(  matcherInside.group(), " ");
                    textLine = textLine.replaceAll("\\s*" + ">",">");
                    textLine = textLine.replace("<div", "<" + matcherInside.group(3));
                    textLine = textLine.replaceAll("\\s+"," ");
                }
            }
            Matcher endMatch = patternEnd.matcher(textLine);
            if (endMatch.find()){
                textLine = endMatch.replaceAll(replaceEnd);
            }

            sb.append(textLine);
            sb.append("\r\n");
        }

        System.out.println(sb.toString());


    }

}
