import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StringMAtrixRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String action = scanner.nextLine();
        List<String> input = new ArrayList<>();

        while(true){
            String currentText = scanner.nextLine();
            if (currentText.equals("END")) {
                break;
            }
            input.add(currentText);
        }

        int maxWordLength = getMaxWordLength(input);
        input = addWordsExtraSpace(input, maxWordLength);
        input = buildResult(input, action, maxWordLength);
        printRotated(input);

    }

    private static  List<String> buildResult(List<String> input, String action, int maxWordLength) {
        int degrees = getRotationDegrees(action);
        int cycles = (degrees / 90) % 4;
        switch (cycles) {
            case 0:
                break;
            case 1:
                input = rotate90Degrees(input, maxWordLength);
                break;
            case 2:
                input = rotate180Degrees(input);
                break;
            case 3:
                input = rotate270Degrees(input, maxWordLength);
                break;
            default:
                break;

        }
        return input;
    }

    private static List<String> rotate270Degrees(List<String> input, int maxWordLength) {
        List<String> result = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int j = maxWordLength-1; j >=0 ; j--) {
            for (int i = 0; i <input.size() ; i++) {
                word.append(input.get(i).charAt(j));
            }
            result.add(word.toString());
            word.setLength(0);
        }
        return result;
    }

    private static List<String> rotate180Degrees(List<String> input) {
        List<String> result = new ArrayList<>();
        for (int i = input.size()-1; i >=0 ; i--) {
            StringBuilder word = new StringBuilder(input.get(i));
            result.add(word.reverse().toString());
        }
        return result;
    }

    private static List<String> rotate90Degrees(List<String> input, int maxWordLength) {
        List<String> result = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int j = 0; j <maxWordLength ; j++) {
            for (int i = input.size()-1; i >=0 ; i--) {
                word.append(input.get(i).charAt(j));
            }
            result.add(word.toString());
            word.setLength(0);
        }
        return result;
    }

    private static void printRotated(List<String> input) {
        for (int i = 0; i <input.size() ; i++) {
            System.out.println(input.get(i));
        }
    }

    private static int getRotationDegrees(String action) {
        int index = action.indexOf('(');
        return Integer.parseInt(action.substring(index+1, action.length()-1));
    }

    private static List<String> addWordsExtraSpace(List<String> input, int maxWordLength) {

        for (int i = 0; i <input.size() ; i++) {
            int currentWordLength = input.get(i).length();
            if (currentWordLength < maxWordLength ) {
                int cycles = maxWordLength - currentWordLength;
                String word = addSpaces(input.get(i), cycles);
                input.set(i,word);
            }
        }
        return input;
    }

    private static String addSpaces(String word, int cycles) {
        for (int i = 0; i <cycles ; i++) {
            word += " ";
        }
        return word;
    }

    private static int getMaxWordLength(List<String> input) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <input.size() ; i++) {
            int currentLength = input.get(i).length();
            if (currentLength > max) {
                max = currentLength;
            }
        }
        return max;
    }

}
