import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TeroristsWin {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("(\\|.*?\\|)");

        while(true) {
            Matcher matcher = pattern.matcher(text);
            if(matcher.find()){
                text = destroyBomb(text, matcher);
            } else {
                break;
            }
        }
        System.out.println(text);
    }

    private static String destroyBomb(String text, Matcher matcher) {
        String bomb = (matcher.group());
        int bombPower = calculateBombPower(bomb);
        String explosionPatternLeft = makeDotPattern(bombPower);
        String explosionPatternRight = explosionPatternLeft;
        String bombPattern = makeDotPattern(bomb.length());

        int startIndex = matcher.start() - bombPower;
        if (startIndex < 0) {
            explosionPatternLeft =makeDotPattern(bombPower+startIndex);
            startIndex = 0;
        }

        int endIndex = matcher.end() + bombPower;
        if (endIndex > text.length()){
            explosionPatternRight =makeDotPattern(text.length() - matcher.end());
            endIndex = text.length();
        }
        text = text.substring(0,startIndex) + explosionPatternLeft + bombPattern + explosionPatternRight + text.substring(endIndex);

        return text;
    }

    private static int calculateBombPower(String bomb) {
        int bombSum = 0;
        for (int i = 1; i <bomb.length()-1 ; i++) {
            bombSum += bomb.charAt(i);
        }
        return bombSum % 10;
    }

    private static String makeDotPattern(int bombPower) {
        String dots = "";
        for (int i = 0; i <bombPower ; i++) {
            dots += ".";
        }
        return dots;
    }


}




