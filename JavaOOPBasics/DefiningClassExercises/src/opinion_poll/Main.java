package opinion_poll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> peoples = new ArrayList<>();

        int cycles = Integer.parseInt(reader.readLine());
        for (int i = 0; i <cycles ; i++) {
            String[] currentPerson = reader.readLine().split("\\s+");
            Person person = new Person(currentPerson[0], Integer.valueOf(currentPerson[1]));
            peoples.add(person);
        }

        peoples.stream().filter(x -> x.getAge()>30)
                .sorted((x, y) -> x.getName().compareTo(y.getName())).forEach(e-> System.out.println(e.getName() + " - " + e.getAge()));
    }
}
