package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> phoneNumbers = Arrays.asList(reader.readLine().split("\\s+"));
        List<String> urls = Arrays.asList(reader.readLine().split("\\s+"));

        Smartphone newPhone = new Smartphone();

        printCallableNumbers(phoneNumbers, newPhone);
        printBrowsableUrls(urls, newPhone);
    }

    private static void printBrowsableUrls(List<String> urls, Smartphone smartphone) {
        Pattern pattern = Pattern.compile(".*[0-9]+.*");
        for (String url:urls) {
            if (!pattern.matcher(url).matches()){
                System.out.println(smartphone.browseInternet(url));
            } else {
                System.out.println("Invalid URL!");
            }
        }
    }

    private static void printCallableNumbers(List<String> phoneNumbers, Smartphone smartphone) {
        Pattern pattern = Pattern.compile("[0-9]+");
        for (String phone:phoneNumbers) {
            if (pattern.matcher(phone).matches()){
                System.out.println(smartphone.callPhone(phone));
            } else {
                System.out.println("Invalid number!");
            }
        }
    }



}
