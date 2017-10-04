import java.util.*;

public class Palindromes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("[ ,\\.!?]", -1);
        Set<String> palindromes = new TreeSet<>();

        for (int i = 0; i <text.length ; i++) {
            String currentWord = text[i];
            if (!currentWord.isEmpty()) {
                String reversedWord = new StringBuilder(currentWord).reverse().toString();
                if (currentWord.equals(reversedWord)) {
                    if (!palindromes.contains(currentWord)){
                        palindromes.add(currentWord);
                    }
                }
            }
        }

        System.out.println(Arrays.toString(palindromes.toArray()));

    }
}
