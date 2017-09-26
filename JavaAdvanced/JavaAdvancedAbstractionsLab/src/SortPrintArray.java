import java.util.Arrays;
import java.util.Scanner;
public class SortPrintArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cycles = Integer.parseInt(scanner.nextLine());
        String[] names = new String[cycles];
        names = fillNames(names, scanner);

        Character[] vowel = new Character[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        long[] encrypt = encryptNames(names, vowel);
        Arrays.sort(encrypt);

        printEncrypt(encrypt);

    }

    private static void printEncrypt(long[] encrypt) {
        for (int i = 0; i <encrypt.length ; i++) {
            System.out.println(encrypt[i]);
        }

    }

    private static long[] encryptNames(String[] names, Character[] vowel) {
        long[] encrypt = new long[names.length];
        for (int i = 0; i <names.length ; i++) {
            String currentName = names[i];
            int sum = 0;
            for (int j = 0; j < currentName.length() ; j++) {
                char currentChar = currentName.charAt(j);
                sum = CalculateSum(vowel, currentChar, sum, currentName);
            }
            encrypt[i] = sum;
        }
        return encrypt;
    }

    private static int CalculateSum(Character[] vowel, char currentChar, int sum, String currentName) {

        for (int i = 0; i <vowel.length ; i++) {
            if (vowel[i] == currentChar) {
                return sum + currentChar * currentName.length();
            }
        }
        return sum + currentChar / currentName.length();
    }

    private static String[] fillNames(String[] names, Scanner scanner) {

        for (int i = 0; i <names.length ; i++) {
            names[i] = scanner.nextLine();
        }
        return names;
    }

}
