import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
public class MatchingBrackets
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <text.length() ; i++) {
            char currentChar = text.charAt(i);
            if (currentChar == '(') {
                stack.push(i);
            } else if (currentChar == ')'){
                System.out.println(text.substring(stack.pop(), i+1));
            }
        }

    }

}
