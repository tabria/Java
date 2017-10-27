import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegularExtensions {


        public static void main(String[] args) throws IOException {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            String text  = reader.readLine();

            while (true){
                String patt = reader.readLine();

                if (patt.equals("Print")){
                    break;
                }

                patt = patt.replaceAll("%", "\\\\E[^\\\\s]*\\\\Q");
                sb.append("\\Q").append(patt).append("\\E");
                Pattern pattern = Pattern.compile(sb.toString());
                sb.setLength(0);

                Matcher match = pattern.matcher(text);
                while (match.find()){
                    String found = match.group(0);
                    sb.append(found).reverse();
                    text = text.replace(found, sb.toString());
                    sb.setLength(0);
                }
            }

            System.out.println(text);
        }

}
