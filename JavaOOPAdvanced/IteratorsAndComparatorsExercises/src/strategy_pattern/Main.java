package strategy_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> personCompareNames = new TreeSet<>(new CompareByNameLenght());
        Set<Person> personCompareAge = new TreeSet<>(new CompareByAge());


        int number = Integer.parseInt(reader.readLine());

        for (int i = 0; i <number ; i++) {
            String[] personInfo = reader.readLine().split("\\s+");
            Person newPerson = new Person(personInfo[0], Integer.parseInt(personInfo[1]));
            personCompareNames.add(newPerson);
            personCompareAge.add(newPerson);
        }

        personCompareNames.forEach(System.out::println);
        personCompareAge.forEach(System.out::println);


    }

}
