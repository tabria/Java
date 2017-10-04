import java.util.Scanner;
public class MagicExchangeableWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        String wordOne = words[0];
        String wordTwo = words[1];

        int firstLength = wordOne.length();
        int secondLength = wordTwo.length();

        int cycles = firstLength;
        if (firstLength < secondLength) {
            cycles = secondLength;
            wordOne = wordTwo;
            wordTwo = words[0];
            firstLength = wordOne.length();
            secondLength = wordTwo.length();
        }

        char[] biggerWord = new char[firstLength];
        char[] smallerWord = new char[secondLength];

        boolean exchangeable = true;

        for (int i = 0; i <cycles ; i++) {
            exchangeable = isExchangeable(wordOne, wordTwo, i, biggerWord, smallerWord);

            if(!exchangeable){
                break;
            }
        }

        System.out.println(exchangeable);
    }

    private static boolean isExchangeable(String wordOne, String wordTwo, int index, char[] biggerWord, char[] smallerWord) {

        char biggerWordChar = getWordChar(wordOne, index);
        char smallerWordChar = getWordChar(wordTwo, index);
        boolean exchangeable = false;

        if (new String(biggerWord).contains("" + biggerWordChar)) {
            for (int i = 0; i <biggerWord.length ; i++) {
                if ((biggerWordChar == biggerWord[i] && smallerWordChar == smallerWord[i]) ||
                    (biggerWordChar == biggerWord[i] && smallerWordChar == '\0')) {
                    exchangeable = true;
                    break;
                }
            }
        } else {
            exchangeable =  isAddToArray(biggerWord, biggerWordChar, index);
            exchangeable =  isAddToArray(smallerWord, smallerWordChar, index);
        }

        return exchangeable;
    }

    private static boolean isAddToArray(char[] currentWord, char currentWordChar, int index) {

        if (currentWordChar != '\0' && index < currentWord.length ){
            currentWord[index] = currentWordChar;
            return true;
        }
        return false;
    }

    private static char getWordChar(String word, int i) {

        char current='\0';
        try{
            current = word.charAt(i);
        } catch (Exception e) {

        }
        return current;
    }


}
