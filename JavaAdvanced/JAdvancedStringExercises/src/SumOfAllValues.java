import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String keyString = scanner.nextLine();
        String textString = scanner.nextLine();

        Pattern startKeyPattern = Pattern.compile("^([a-zA-Z_]*)[0-9]+");
        Pattern endKeyPattern = Pattern.compile("\\d([a-zA-Z_]*)$");

        String startKey = getKey(keyString, startKeyPattern);
        String endKey = getKey(keyString, endKeyPattern);

        if (startKey.isEmpty() || endKey.isEmpty()){
            System.out.println("<p>A key is missing</p>");
        } else {
            double sum = calculateSum(startKey, endKey, textString);
            if (sum == 0) {
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            } else {
                if (sum % 1 == 0) {
                    System.out.printf("<p>The total value is: <em>%d</em></p>%n", (int) sum);
                } else {
                    System.out.printf("<p>The total value is: <em>%.2f</em></p>%n", sum);
                }
            }
        }
    }

    private static double calculateSum(String startKey, String endKey, String textString) {
        double sum =0;

        Pattern sumPattern = Pattern.compile(startKey + "([\\d]*\\.?[\\d]*)" +endKey);
        Matcher sumMatch = sumPattern.matcher(textString);
        while(sumMatch.find() && !sumMatch.group(1).isEmpty()){
            sum += Double.parseDouble(sumMatch.group(1));
        }

        return sum;

    }

    private static String getKey(String keyString, Pattern keyPattern) {
        Matcher keyMatch = keyPattern.matcher(keyString);
        if (keyMatch.find()) {
            return keyMatch.group(1);
        }
        return "";
    }

}
