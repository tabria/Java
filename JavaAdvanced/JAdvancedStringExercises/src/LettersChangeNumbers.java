import java.util.Scanner;
public class LettersChangeNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+");

        double sum = 0.0;

        for (int i = 0; i <text.length ; i++) {
            String currentWord = text[i];
            int lastCharPosition = currentWord.length()-1;
            char firstLetter = currentWord.charAt(0);
            char lastLetter = currentWord.charAt(lastCharPosition);
            double number = Double.parseDouble(currentWord.substring(1, lastCharPosition));

            number = firstLetterActions(firstLetter, number);
            number = lastLetterActions(lastLetter, number);

            sum += number;
        }

        System.out.printf("%.2f", sum);

    }

    private static double lastLetterActions(char lastLetter, double number) {
        int position = getCharPosition(lastLetter);
        if (Character.isLowerCase(lastLetter)){
            number += position;
        } else {
            number -=position;
        }

        return number;
    }

    private static double firstLetterActions(char firstLetter, double number) {
        int position = getCharPosition(firstLetter);
        if (Character.isLowerCase(firstLetter)){
            number *= position;
        } else {
            number /= position;
        }

        return number;
    }

    private static int getCharPosition(char currentChar) {
        char charLowerCase = Character.toLowerCase(currentChar);
        return charLowerCase - 96;
    }

}
