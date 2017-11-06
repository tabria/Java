package stack_strings;

public class Main {

    public static void main(String[] args) {
        StackOfStrings st = new StackOfStrings();
        st.push("Gosho");
        st.push("Boko");
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());

    }

}
