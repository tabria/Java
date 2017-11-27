package stack_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StackInterface<String> newStack = new Stack<>();

        String input = "";
        while(!"END".equals(input = reader.readLine())){
            String[] command = input.split("\\s+|,\\s+");

            switch(command[0]){
                case "Push":
                    String[] elements = Arrays.stream(command).skip(1L).toArray(String[]::new);
                    newStack.push(elements);
                    break;
                case "Pop":
                    try {
                        newStack.pop();
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }


        StringBuilder sb = new StringBuilder();
        newStack.forEach(e-> sb.insert(0,String.format("%s%n", e)));
        newStack.forEach(e-> sb.insert(0,String.format("%s%n", e)));
        System.out.print(sb.toString().trim());


    }

}
