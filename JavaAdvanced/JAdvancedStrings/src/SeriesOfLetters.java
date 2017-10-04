import java.util.Scanner;
public class SeriesOfLetters {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[] text = scanner.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        int state = 0;
        char prev=text[0];
        for (int i = 0; i <text.length ; i++) {
            switch(state){
                case 0:
                    state = 1;
                    prev = text[i];
                    break;
                case 1:
                    sb.append(prev);
                    state = prev == text[i] ? 2 : 1;
                    prev = text[i];
                    break;
                case 2:
                    state = prev != text[i] ? 1 : 2;
                    prev = text[i];
                    break;
            }
        }
        if (text[text.length - 2] != prev) {
            sb.append(prev);
        }
        System.out.println(sb.toString());

    }
}
