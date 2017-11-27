package border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Habitant> habitants = new LinkedList<>();

        addHabitants(habitants, reader);

        String idEnd = reader.readLine();
        for (Habitant habitant:habitants) {
            habitant.printDetainedId(idEnd);
        }
    }

    private static void addHabitants(List<Habitant> habitants, BufferedReader reader) throws IOException {
        while(true){
            String input = reader.readLine().trim();
            if ("End".equals(input)){
                break;
            }
            List<String> enterHabitatnt = Arrays.asList(input.split("\\s+"));
            if (enterHabitatnt.size()> 2){
                Habitant newHabitant = new Citizen(enterHabitatnt.get(0), Integer.parseInt(enterHabitatnt.get(1)), enterHabitatnt.get(2));
                habitants.add(newHabitant);
            } else {
                Habitant newHabitant = new Robot(enterHabitatnt.get(0), enterHabitatnt.get(1));
                habitants.add(newHabitant);
            }
        }
    }

}
