import java.util.*;

public class InfixToPostfix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] expression = scanner.nextLine().split(" ");

        LinkedHashMap<Character, List<String>> operatorsInfo = new LinkedHashMap<>();
        Deque<Character> stack = new ArrayDeque<>();
        Deque<String> queue = new ArrayDeque<>();

        fillPrecedenceAssociativity(operatorsInfo);
        for (int i = 0; i <expression.length ; i++) {
            char currentChar = expression[i].charAt(0);
            if (expression[i].length()> 1){
                queue.offer(expression[i]);
            } else if (Character.isDigit(currentChar)){
                queue.offer(Character.toString(currentChar));
            } else if (currentChar == '('){
                stack.push(currentChar);
            } else if (currentChar == '^' || currentChar == '*' || currentChar == '/' ||
                        currentChar == '+' || currentChar == '-') {
                addOperator(operatorsInfo, stack, queue, currentChar);
            } else if (currentChar == ')'){
                bracketOperation(stack, queue);
            } else {
                queue.offer(expression[i]);
            }
        }
        while(!stack.isEmpty()){
            queue.offer(Character.toString(stack.pop()));
        }
        for (String element : queue) {
            System.out.print(element + " ");
        }
    }

    private static void bracketOperation(Deque<Character> stack, Deque<String> queue) {
        while(true){
            if (stack.isEmpty()){
                break;
            } else if (stack.peek() == '('){
                stack.pop();
                break;
            } else {
                queue.offer(String.valueOf(stack.pop()));
            }
        }
    }

    private static void addOperator(LinkedHashMap<Character, List<String>> operatorsInfo, Deque<Character> stack, Deque<String> queue, char currentChar) {
        String operatorAssociative = operatorsInfo.get(currentChar).get(1);
        int operatorPrecedence = Integer.parseInt(operatorsInfo.get(currentChar).get(0));
        while(true){
            if (!stack.isEmpty() && operatorAssociative.equals("Left")){
                char stackOperator = stack.peek();
                if (stackOperator == '('){
                    break;
                }
                int stackOperatorPrecedence = Integer.parseInt(operatorsInfo.get(stackOperator).get(0));
                if (operatorPrecedence <= stackOperatorPrecedence){
                    queue.offer(String.valueOf(stack.pop()));
                }else {
                    break;
                }
            } else {
                break;
            }
        }
        stack.push(currentChar);
    }

    private static void fillPrecedenceAssociativity(LinkedHashMap<Character, List<String>> operatorsInfo) {

        char[] operators = {'^','*','/','+', '-'};

        for (char element : operators) {
            List<String> values = new ArrayList<>();
            switch(element){
                case '^':
                    values.add("4");
                    values.add("Right");
                    operatorsInfo.put('^', values);
                    break;
                case '*':
                    values.add("3");
                    values.add("Left");
                    operatorsInfo.put('*', values);
                    break;
                case '/':
                    values.add("3");
                    values.add("Left");
                    operatorsInfo.put('/', values);
                    break;
                case '+':
                    values.add("2");
                    values.add("Left");
                    operatorsInfo.put('+', values);
                    break;
                case '-':
                    values.add("2");
                    values.add("Left");
                    operatorsInfo.put('-', values);
                    break;
            }
        }
        
    }


}
