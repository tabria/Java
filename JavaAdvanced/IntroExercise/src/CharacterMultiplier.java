import java.math.BigInteger;
import java.util.Scanner;
public class CharacterMultiplier {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String firstWord = scanner.next();
        String secondWord = scanner.next();

        int result = 0;
        int firstLenght = firstWord.length();
        int secondLenght = secondWord.length();
        int cycles = firstLenght  >= secondLenght ? firstLenght  : secondLenght;

        for (int i = 0; i < cycles ; i++) {
            if (i+1 > firstLenght){
                result += secondWord.charAt(i);
            } else if (i+1 > secondLenght ) {
                result += firstWord.charAt(i);
            } else {
                int pairMultiply = firstWord.charAt(i) * secondWord.charAt(i);
                result += pairMultiply;
            }
        }

        System.out.println(result);
    }

}
