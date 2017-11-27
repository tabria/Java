package linked_list_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> newList = new LinkedListImpl<>();

        int number = Integer.parseInt(reader.readLine());
        for (int i = 0; i <number ; i++) {
            String[] command = reader.readLine().split("\\s+");
            switch(command[0]){
                case "Add":
                    newList.add(Integer.parseInt(command[1]));
                    break;
                case "Remove":
                    newList.remove(Integer.parseInt(command[1]));
                    //System.out.println(newList.remove(Integer.parseInt(command[1])));
                    break;
            }
        }
        System.out.println(newList.getSize());
        newList.forEach(e -> System.out.print(e + " "));
    }

}
