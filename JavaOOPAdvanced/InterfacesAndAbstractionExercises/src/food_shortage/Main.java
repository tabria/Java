package food_shortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Human> habitants = new LinkedList<>();

        addHabitants(habitants, reader);

        int totalFood = 0;
        while(true){
            String name = reader.readLine();
            if ("End".equals(name)){
                break;
            }
            for (Human habitant:habitants) {
                if (habitant.getName().equals(name)){
                    habitant.buyFood();
                }
            }
        }

        System.out.println( habitants.stream().mapToInt(h -> h.getFood() ).sum());
    }

    private static void addHabitants(List<Human> habitants, BufferedReader reader) throws IOException {
        int cycles = Integer.parseInt(reader.readLine());
        for (int i = 0; i <cycles ; i++) {
            List<String> enterHabitatnt = Arrays.asList(reader.readLine().split("\\s+"));

            if(enterHabitatnt.size()> 3){
                Human newHabitant = new Citizen(enterHabitatnt.get(0), Integer.parseInt(enterHabitatnt.get(1)), enterHabitatnt.get(2), enterHabitatnt.get(3));
                habitants.add(newHabitant);
            } else {
                Human newHabitant = new Rebel(enterHabitatnt.get(0), Integer.parseInt(enterHabitatnt.get(1)), enterHabitatnt.get(2));
                habitants.add(newHabitant);
            }
        }
    }

}
