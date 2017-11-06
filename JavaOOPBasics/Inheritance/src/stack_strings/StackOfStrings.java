package stack_strings;

import java.util.ArrayList;

public class StackOfStrings {

    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }

    public void push(String str){
        this.data.add(str);
    }

    public String pop(){
        return this.data.remove(this.data.size()-1);
    }

    public String peek(){
        return this.data.get(this.data.size()-1);
    }
}
