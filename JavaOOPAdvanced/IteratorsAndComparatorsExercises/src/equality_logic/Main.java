package equality_logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> normalPerson = new TreeSet<>();
        Set<Person> hashedPerson = new HashSet<>();

        int cycles = Integer.parseInt(reader.readLine());
        for (int i = 0; i <cycles ; i++) {
            String[] input = reader.readLine().split("\\s+");
            Person newPerson = new PersonImpl(input[0], Integer.parseInt(input[1]));
            normalPerson.add(newPerson);
            hashedPerson.add(newPerson);
        }

        System.out.println(normalPerson.size());
        System.out.println(hashedPerson.size());

    }
}
