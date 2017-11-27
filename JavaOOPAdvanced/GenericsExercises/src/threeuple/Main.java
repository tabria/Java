package threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split("\\s+");
        System.out.println(new Threeuple<>(firstLine[0] + " " + firstLine[1], firstLine[2], firstLine[3]));

        String[] secondLine = reader.readLine().split("\\s+");
        System.out.println(new Threeuple<>(secondLine[0], Integer.parseInt(secondLine[1]), secondLine[2].equals("drunk")));

        String[] thirdLine = reader.readLine().split("\\s+");
        Threeuple<String, Double, String> newThreeuple = new Threeuple<>(thirdLine[0], Double.parseDouble(thirdLine[1]), thirdLine[2]);
        System.out.println(newThreeuple);

    }

}
