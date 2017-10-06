import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<Character, Integer> counter = new TreeMap<>();

        String text = scanner.nextLine();

        for (int i = 0; i <text.length() ; i++) {
            char currentChar = text.charAt(i);
            if (counter.containsKey(currentChar)){
                counter.put(currentChar, counter.get(currentChar) + 1);
            } else {
                counter.put(currentChar, 1);
            }
        }

        for (char letter : counter.keySet()) {
            System.out.println(letter + ": " + counter.get(letter) + " time/s");
        }

    }

}
