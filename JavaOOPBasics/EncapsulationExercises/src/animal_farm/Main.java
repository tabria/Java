package animal_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("#.##");

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        try {
            Chicken newChicken = new Chicken(name, age);
            System.out.printf("Chicken %s (age %d) can produce %s eggs per day.", newChicken.getName(), newChicken.getAge(), df.format(newChicken.productPerDay()));
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

}
