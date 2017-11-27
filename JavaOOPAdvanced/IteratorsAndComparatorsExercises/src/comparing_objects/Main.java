package comparing_objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String line ="";
        while(!"END".equals(line = reader.readLine())){

            String[] input = line.split("\\s+");
            Person newPerson = new  Person(input[0], Integer.parseInt(input[1]), input[2]);
            people.add(newPerson);

        }
        int targetIndex = Integer.parseInt(reader.readLine());
        if (targetIndex > people.size()-1 || targetIndex < 0){
            System.out.println("No matches");
        } else {
            Person person = people.get(targetIndex);
            int[] result = new int[2];
            for (int i = 0; i <people.size() ; i++) {
                if (person.compareTo(people.get(i)) == 0){
                    result[0]++;
                } else {
                    result[1]++;
                }
            }
            System.out.println(String.format("%d %d %d", result[0], result[1], people.size()));
        }
    }


}
