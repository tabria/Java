import java.util.Scanner;
public class ParseTags {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String startTag = "<upcase>";
        String endTag = "</upcase>";

        StringBuilder sb = new StringBuilder();

        while(text.contains(startTag)) {

            int startIndex = text.indexOf(startTag);
            int endIndex = text.indexOf(endTag);
            String strToUpper = text.substring(startIndex + startTag.length(),endIndex).toUpperCase();
            String textBeforeTag = text.substring(0, startIndex);
            text = text.substring(endIndex + endTag.length());
            sb.append(textBeforeTag);
            sb.append(strToUpper);

        }
        sb.append(text);
        System.out.println(sb.toString());

    }

}
