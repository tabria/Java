import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
public class BalancedParentheses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deque<Character> parentheses = new ArrayDeque<>();

        fillQueue(parentheses, scanner);

        String balanced = "NO";
        for (int i = 0; i <parentheses.size() ; i++) {
            if (parentheses.size() % 2 != 0){
                break;
            }

            char firstElement = parentheses.removeFirst();
            char element = parentheses.peekFirst();
            balanced = balance(parentheses, firstElement, element);

            if (balanced.equals("YES")){
                continue;
            } else {
                element = parentheses.removeLast();
                balanced = balance(parentheses, firstElement, element);
            }

            if (balanced.equals("NO")){
                break;
            }
        }
        System.out.println(balanced);
    }

    private static void fillQueue(Deque<Character> parentheses, Scanner scanner) {
        String text = scanner.nextLine();
        for (int i = 0; i <text.length() ; i++) {
            parentheses.offer(text.charAt(i));
        }

    }

    private static String balance(Deque<Character> parentheses, char firstElement, char element) {
        String balance = "NO";
        switch (firstElement){
            case '{':
                balance = element == '}' ? "YES" : "NO";
                break;
            case '[':
                balance = element == ']' ? "YES" : "NO";
                break;
            case '(':
                balance = element == ')' ? "YES" : "NO";
                break;
        }
        return balance;
    }

}
