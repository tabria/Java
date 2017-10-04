import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String[] usernames = text.split("[ \\/\\\\()]");
        String[] validUsernames = getValidUsernames(usernames, text);
        long lastSum = Long.MIN_VALUE;
        String[] result = new String[2];

        for (int i = 1; i <validUsernames.length ; i++) {

            String firstUsername = validUsernames[i-1];
            String secondUsername = validUsernames[i];

            long sum = firstUsername.length() + secondUsername.length();

            if (sum > lastSum) {
                lastSum = sum;
                result[0]=firstUsername;
                result[1]=secondUsername;
            }
        }
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    private static String[] getValidUsernames(String[] usernames, String text) {

        String[] validUsers = new String[usernames.length];
        int count = 0;
        Pattern validationPattern = Pattern.compile("(?<=[ \\/\\\\()]|^)([a-zA-Z][\\w]{2,24})(?=[ \\/\\\\()]|$)");
            Matcher matcher = validationPattern.matcher(text);
            while (matcher.find()){
                validUsers[count] = matcher.group();
                count++;
            }
        String[] result = new String[count];
        for (int i = 0; i <result.length ; i++) {
            result[i] = validUsers[i];
        }

        return result;
    }

}
