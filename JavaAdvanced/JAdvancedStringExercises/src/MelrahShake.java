import java.util.Scanner;
public class MelrahShake {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String pattern = scanner.nextLine();

        while(true) {
            String textAfterShake = shakeOff(text,pattern);
            if (text.equals(textAfterShake)){
                System.out.println("No shake.");
                System.out.println(text);
                break;
            } else {

                text = textAfterShake;
                pattern = makeNewPattern(pattern);
                System.out.println("Shaked it.");
            }
        }
    }

    private static String makeNewPattern(String pattern) {

        int index = pattern.length()/2;
        return pattern.substring(0, index) + pattern.substring(index+1);
    }

    private static String shakeOff(String text, String pattern) {

        int firstOccurrence = text.indexOf(pattern);
        int lastOccurrence = text.lastIndexOf(pattern);

        StringBuilder sb = new StringBuilder(text);

        if ( (firstOccurrence > -1 && lastOccurrence > -1) && firstOccurrence != lastOccurrence ) {
            sb.replace(firstOccurrence, firstOccurrence + pattern.length(), "");
            lastOccurrence = sb.lastIndexOf(pattern);
            sb.replace(lastOccurrence, lastOccurrence + pattern.length(), "");
            text = sb.toString();
        }

        return text;
    }

}
