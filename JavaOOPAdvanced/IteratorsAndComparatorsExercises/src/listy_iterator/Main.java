package listy_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ListyInterface<String> listy = new ListyIterator<>() ;

        String line = "";
        while (!"END".equals(line = reader.readLine())){
            String[] input = line.split("\\s+");

            switch(input[0]){
                case "Create":
                        String[] arr = Arrays.stream(input).skip(1L).toArray(String[]::new);
                        listy.create(arr);
                    break;
                case "Move":
                    System.out.println(listy.move());
                    break;
                case "Print":
                    try{
                        listy.print();
                    } catch (UnsupportedOperationException uoe){
                        System.out.println(uoe.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listy.hasNext());
                    break;
            }
        }

    }

}
