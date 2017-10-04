import java.util.Scanner;
public class CountSubstring {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split(" ");
        String subText = scanner.nextLine().toLowerCase();
        int count = 0;

        for (int i = 0; i <text.length ; i++) {
           String currentWord = text[i].toLowerCase();
            for (int j = 0; j <text[i].length() ; j++) {
                int indexSubStr = currentWord.indexOf(subText);
                if (indexSubStr > -1) {
                    count++;
                    int offset = subText.length()-1 <= 0 ? subText.length() : subText.length() - 1;
                    currentWord = currentWord.substring(indexSubStr + offset);
                } else {
                    break;
                }
            }
        }
        System.out.println(count);

    }

}
