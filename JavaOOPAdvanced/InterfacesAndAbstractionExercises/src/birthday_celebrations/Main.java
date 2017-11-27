package birthday_celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Habitant> habitants = new LinkedList<>();
        List<NonRobots> nonRobots = new LinkedList<>();

        addHabitants(habitants, reader, nonRobots);

        String yearEnd = reader.readLine();
        for (NonRobots nonRobot:nonRobots) {
            nonRobot.printBirthday(yearEnd);
        }
    }

    private static void addHabitants(List<Habitant> habitants, BufferedReader reader, List<NonRobots> nonRobots) throws IOException {
        while(true){
            String input = reader.readLine().trim();
            if ("End".equals(input)){
                break;
            }
            List<String> enterHabitatnt = Arrays.asList(input.split("\\s+"));

            switch(enterHabitatnt.get(0)){
                case "Citizen":
                    NonRobots newHabitant = new Citizen(enterHabitatnt.get(1), Integer.parseInt(enterHabitatnt.get(2)), enterHabitatnt.get(3), enterHabitatnt.get(4));
                    nonRobots.add(newHabitant);
                    break;
                case "Robot":
                    Habitant newRobot = new Robot(enterHabitatnt.get(1), enterHabitatnt.get(2));
                    habitants.add(newRobot);
                    break;
                case "Pet":
                    Pet newPet = new Pet(enterHabitatnt.get(1), enterHabitatnt.get(2));
                    nonRobots.add(newPet);
                    break;
            }
        }
    }

}
