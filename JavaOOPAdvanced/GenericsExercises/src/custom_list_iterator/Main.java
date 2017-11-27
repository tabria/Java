package custom_list_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> newCustomList = new CustomList();

        while(true){
            String[] commands = reader.readLine().split("\\s+");
            if ("end".equalsIgnoreCase(commands[0])){
                break;
            }

            switch(commands[0]){
                case"Add":
                    newCustomList.add(commands[1]);
                    break;
                case "Remove":
                    newCustomList.remove(Integer.parseInt(commands[1]));
                    break;
                case "Contains":
                    System.out.println(newCustomList.contains(commands[1]));
                    break;
                case "Swap":
                    newCustomList.swap(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                    break;
                case "Greater":
                    System.out.println(newCustomList.countGreaterThan(commands[1]));
                    break;
                case "Max":
                    System.out.println(newCustomList.getMax());
                    break;
                case "Min":
                    System.out.println(newCustomList.getMin());
                    break;
                case "Print":
                    for (String element:newCustomList) {
                        System.out.println(element);
                    }
                    break;
                case "Sort":
                    Sorter.sort(newCustomList);
                    break;
            }
        }

    }

}
