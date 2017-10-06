import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
public class SimpleTextEditor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int operations = Integer.parseInt(scanner.nextLine());
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        stack.push(sb.toString());
        for (int i = 0; i <operations ; i++) {
            String[] commands = scanner.nextLine().split(" ");
            String action = commands[0];
            if (action.equals("1")) {
                sb.append(commands[1]);
                stack.push(sb.toString());
            } else if (action.equals("2")) {
                int cycles = Integer.parseInt(commands[1]);
                int sbStartIndex = sb.length()-1;
                for (int j = sbStartIndex; j >sbStartIndex - cycles ; j--) {
                    sb.deleteCharAt(j);
                }
                stack.push(sb.toString());
            } else if (action.equals("3")){
                System.out.println(sb.charAt(Integer.parseInt(commands[1])-1));
            } else if (action.equals("4")){
                sb.setLength(0);
                stack.pop();
                sb.append(stack.peek());
            }
        }
    }

}
